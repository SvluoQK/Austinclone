package com.hao.messagesearch.demo.Base;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */


public class ReturnUtil {
    /**
     * 返回成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 错误
     *
     * @param code
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> BaseResponse<T> error(int code, String errorMessage) {
        return new BaseResponse<>(code, null, errorMessage);
    }
}
