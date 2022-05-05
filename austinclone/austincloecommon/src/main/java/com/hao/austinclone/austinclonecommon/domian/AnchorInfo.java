package com.hao.austinclone.austinclonecommon.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnchorInfo {
    /**
     * 发送的用户 居然是用的list
     */
    private Set<String> ids;

    /**
     * 发送的业务代码
     */
    private Long BusinessID;

    /**
     * 点位
     */
    private int state;

    /**
     * 生成的时间
     */
    private long timestamp;



}

