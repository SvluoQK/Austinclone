package com.hao.leanone.Base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */


@Data
@AllArgsConstructor
@Accessors(chain = true)
public class SendResponse {
    /**
     * 响应状态
     *
     */
    private String code;

    /**
     * 相应编码
     *
     */
    private String msg;

}
