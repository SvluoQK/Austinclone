package com.hao.messagesearch.demo.Base;

import lombok.Data;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
public class BaseResponse<T> {

    public BaseResponse(int code, T data, String RMessage) {
        this.code = code;
        this.data = data;
        this.RMessage = RMessage;
    }

    private int code;
    private  T data;
    private String RMessage;



}
