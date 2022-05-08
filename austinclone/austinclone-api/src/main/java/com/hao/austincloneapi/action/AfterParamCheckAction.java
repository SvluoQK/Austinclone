package com.hao.austincloneapi.action;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.json.JSONString;
import com.alibaba.fastjson.JSON;
import com.hao.austinclone.pipline.BusinessProcess;
import com.hao.austinclone.pipline.ProcessContext;
import com.hao.austincloneapi.domain.SendTaskModel;
import com.java3y.austin.common.domain.TaskInfo;
import com.java3y.austin.common.enums.ChannelType;
import com.java3y.austin.common.enums.IdType;
import com.java3y.austin.common.enums.RespStatusEnum;
import com.java3y.austin.common.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Slf4j
public class AfterParamCheckAction implements BusinessProcess {

    public static final String PHONE_REGEX_EXP = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[0-9])|(18[0-9])|(19[1,8,9]))\\d{8}$";

    @Override
    public void process(ProcessContext processContext) {
        SendTaskModel  sendTaskModel = (SendTaskModel) processContext.getProcessModel();
        List<TaskInfo> taskInfo = sendTaskModel.getTaskInfo();

        // 1. 过滤掉不合法的手机号
        filterIllegalPhoneNum(taskInfo);

        if(CollUtil.isEmpty(taskInfo)){
            processContext.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
        }

    }

    /**
     * 如果指定类型是手机号，且渠道是发送短信，检测输入手机号是否合法
     *
     * @param taskInfo
     */
    private void filterIllegalPhoneNum(List<TaskInfo> taskInfo) {
        Integer idType  = CollUtil.getFirst(taskInfo.iterator()).getIdType();
        Integer sendChannel = CollUtil.getFirst(taskInfo.iterator()).getSendChannel();

        if(IdType.PHONE.getCode().equals(idType) && ChannelType.SMS.getCode().equals(sendChannel)){
            Iterator<TaskInfo> iterator = taskInfo.iterator();

            while(iterator.hasNext()){
                TaskInfo task = iterator.next();
                Set<String> illegalPhone = task.getReceiver().stream()
                        .filter(phone -> !ReUtil.isMatch(PHONE_REGEX_EXP, phone))
                        .collect(Collectors.toSet());



                if(CollUtil.isNotEmpty(illegalPhone)){
                    task.getReceiver().removeAll(illegalPhone);
                    log.error("illegal phone!!!",task.getMessageTemplateId(), JSON.toJSONString(illegalPhone)
                    );


                }

                if(CollUtil.isEmpty(illegalPhone)){
                    iterator.remove();
                }

            }


        }


    }

}
