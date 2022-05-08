package com.hao.austinclone.pending;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 延迟消费 阻塞队列-消费者和生产者实现
 */

@Slf4j
@Data
public abstract class  AbstractLazyPending<T> {
    /**
     * 子类构造方法必须初始化该参数
     */
    protected PendingParam<T> pendingParam;

    /**
     * 批量装载任务
     */
    private List<T> tasks = new ArrayList<>();

    /**
     * 上次执行的时间
     */
    private Long lastHandleTime = System.currentTimeMillis();

    /**
     *  单线程消费 阻塞队列的数据
     */
    public void initConsumePending(){
        ThreadUtil.newSingleExecutor().execute(() ->{
            while(true){
                try{
                    T obj = pendingParam.getQueue().poll(pendingParam.getTimeThreshold(), TimeUnit.MILLISECONDS);
                    if(obj != null){
                        tasks.add(obj);
                    }
                    if(CollUtil.isNotEmpty(tasks) && dataReady()){
                        List<T> taskRef = tasks;
                        tasks = Lists.newArrayList();
                        lastHandleTime = System.currentTimeMillis();

                        pendingParam.getExecutorService().execute(() ->{
                            this.handle(taskRef);
                        });
                    }

                }catch (Exception e){
                    log.error("failed", Throwables.getStackTraceAsString(e));

                }
            }

                }
                );
    }

    /**
     *
     * @param taskRef 处理阻塞队列元素的方法
     */
    public void handle(List<T> taskRef){
        if(taskRef.isEmpty()){
            return;
        }
        try{
            doHandle(taskRef);
        }catch (Exception e){
            log.error("pending#handle failed", Throwables.getStackTraceAsString(e));
        }
    }

    protected abstract void doHandle(List<T> taskRef);



    /**
     * 元素放入阻塞队列中
     */
    public void pending(T t){
        try{
            pendingParam.getQueue().put(t);

        }catch (InterruptedException e){
            log.error("Pending error", Throwables.getStackTraceAsString(e));
        }

    }


    /**
     * 判断任务是否超时 或者是否超过
     * @return
     */
    private boolean dataReady(){

        return tasks.size()>=pendingParam.getNumThreshold() ||
                (System.currentTimeMillis()- lastHandleTime >= pendingParam.getTimeThreshold()
                );
    };


}
