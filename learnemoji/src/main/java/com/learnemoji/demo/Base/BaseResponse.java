package com.learnemoji.demo.Base;

import lombok.Data;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
public class BaseResponse<T> {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
