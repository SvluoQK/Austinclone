package com.hao.austinclone.austinclonecommon.enums;

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
@AllArgsConstructor
@ToString
public enum AuditStatus {

    /**
     *
     */
    WAIT_AUDIT(10, "待审核"),
    AUDIT_SUCCESS(20, "审核成功"),
    AUDIT_REJECT(30, "被拒绝");


    private Integer code;
    private String description;


}
