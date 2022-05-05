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
public enum AnchorState {

    RECEIVE(10, "消息接收成功"),
    DISCARD(20, "消费被丢弃"),
    CONTENT_DEDUPLICATION(30, "消息被内容去重"),
    RULE_DEDUPLICATION(40, "消息被频次去重"),
    WHITE_LIST(50, "白名单过滤"),
    SEND_SUCCESS(60, "消息下发成功"),
    SEND_FAIL(70, "消息下发失败"),
    CLICK(0100, "消息被点击"),
    ;

    private Integer code;
    private String description;

    public static String getDescriptionByCode(Integer code){

        for(AnchorState anchorState: AnchorState.values()){
            if(anchorState.getCode().equals(code)){
                return anchorState.getDescription();
            }
        }
        return "Unknown！！";
    }

}
