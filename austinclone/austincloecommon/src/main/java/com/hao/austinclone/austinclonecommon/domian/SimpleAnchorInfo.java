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
public class SimpleAnchorInfo {

    /**
     * 具体点位
     */
    private int state;

    /**
     * 业务Id(数据追踪使用)
     * 生成逻辑参考 TaskInfoUtils
     */
    private Long businessId;

    /**
     * 生成时间
     */
    private long timestamp;

}
