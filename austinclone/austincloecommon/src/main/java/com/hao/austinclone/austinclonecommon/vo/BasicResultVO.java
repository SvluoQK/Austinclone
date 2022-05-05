package com.hao.austinclone.austinclonecommon.vo;


import com.hao.austinclone.austinclonecommon.enums.RespStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public final class BasicResultVO<T> {

    /**
     * 响应状态
     */
    private String status;

    /**
     * 相应编码
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BasicResultVO(RespStatusEnum status) {
        this(status, null);
    }

    public BasicResultVO(RespStatusEnum status, T data){

        this(status, status.getMsg(), data);
    }

    public BasicResultVO(RespStatusEnum status, String msg, T data){
        this.status = status.getCode();
        this.msg = msg;
        this.data = data;

    }

    /**
     * 默认响应成功
     */
    public static BasicResultVO success(){return new BasicResultVO<>(RespStatusEnum.SUCCESS);
    }

    /**
     * 带信息的响应成功
     */
    public static BasicResultVO success(String msg){
        return new BasicResultVO<>(RespStatusEnum.SUCCESS,msg,null);
    }

    /**
     * 带数据的响应成功
     */
    public static <T> BasicResultVO<T> success(T data){
        return new BasicResultVO<T>(RespStatusEnum.SUCCESS, data);
    }

    /**
     * 相应失败
     */
    public static <T> BasicResultVO<T> fail() {
        return new BasicResultVO<>(
                RespStatusEnum.FAIL,
                RespStatusEnum.FAIL.getMsg(),
                null
        );
    }

    /**
     * 自定义错误信息的失败响应
     *
     * @param msg 错误信息
     * @return 自定义错误信息的失败响应
     */
    public static <T> BasicResultVO<T> fail(String msg) {
        return fail(RespStatusEnum.FAIL, msg);
    }


    public static <T> BasicResultVO<T> fail(RespStatusEnum status) {
        return fail(status, status.getMsg());
    }

    /**
     * 自定义状态和信息的失败响应
     *
     * @param status 状态
     * @param msg    信息
     * @return 自定义状态和信息的失败响应
     */
    public static <T> BasicResultVO<T> fail(RespStatusEnum status, String msg) {
        return new BasicResultVO<>(status, msg, null);
    }






}
