package com.hao.austinclone.austinclonecommon.dto;

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
@AllArgsConstructor
@NoArgsConstructor
public class SmsContentModel extends ContentModel{
    /**
     * 发送的内容
     *
     */
    private String content;

    /**
     * 发送的链接
     */
    private String url;
}
