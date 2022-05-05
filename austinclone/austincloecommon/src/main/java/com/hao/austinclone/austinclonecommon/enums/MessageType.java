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
public enum MessageType {

    NOTICE(10,"通知类消息","notice"),
    MARKETING(20,"营销类消息","marketing"),
    AUTH_CODE(30,"验证码消息","auth_code")
    ;
    /**
     * 编码值
     */
    private Integer code;

    /**
     * 描述
     */
    private String description;


    /**
     * 英文标识
     */
    private String codeEn;

    /**
     * 通过code获取enum
     * @param
     * @return
     */
    public static MessageType getEnumByCode(Integer code) {
        MessageType[] values = values();
        for (MessageType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


}