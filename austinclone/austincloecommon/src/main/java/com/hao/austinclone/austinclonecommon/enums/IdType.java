package com.hao.austinclone.austinclonecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Getter
@ToString
@AllArgsConstructor
public enum IdType {
    USER_ID(10, "userId"),
    DID(20, "did"),
    PHONE(30, "phone"),
    OPEN_ID(40, "openId"),
    EMAIL(50, "email");


    private Integer code;
    private String description;
}
