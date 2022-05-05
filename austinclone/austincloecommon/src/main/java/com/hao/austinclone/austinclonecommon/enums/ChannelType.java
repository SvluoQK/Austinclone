package com.hao.austinclone.austinclonecommon.enums;

import com.hao.austinclone.austinclonecommon.dto.*;
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
public enum ChannelType {

    IM(10, "IM(站内信)", ImContentModel.class, "im"),
    SMS(30, "sms(短信)", SmsContentModel.class, "sms"),
    PUSH(20, "push(通知栏)", PushContentModel.class, "push"),
    EMAIL(40, "email(邮件)", EmailContentModel.class, "email"),
    OFFICIAL_ACCOUNT(50, "OfficialAccounts(服务号)", OfficialAccountsContentModel.class, "official_accounts"),
    MINI_PROGRAM(60, "miniProgram(小程序)", miniProgramModel.class, "mini_program"),
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
     * 内容模型Class
     */
    private Class contentModelClass;

    /**
     * 英文标识
     */
    private String codeEn;


    /**
     * 通过 code获取 信息？？
     */
    public static Class getChannelModelByCode(Integer code){
        ChannelType[] values = values();
        for (ChannelType value : values) {
            if (value.getCode().equals(code)) {
                return value.getContentModelClass();
            }
        }
        return null;
    }

    /**
     *  获取code
     */
    public static ChannelType getEnumByCode(Integer code){
        ChannelType[] values = values();
        for (ChannelType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }







}
