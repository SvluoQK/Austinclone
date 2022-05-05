package com.hao.austinclone.austinclonecommon.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogParam {
    /**
     * 需要记录的日志
     */
    private Object object;

    /**
     * 标识日志的业务
     */
    private String bizType;

    /**
     * 生成时间
     */
    private long timestamp;
}
