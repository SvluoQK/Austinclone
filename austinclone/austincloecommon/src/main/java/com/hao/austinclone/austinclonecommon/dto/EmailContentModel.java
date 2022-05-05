package com.hao.austinclone.austinclonecommon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 发送Email的内容
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailContentModel extends ContentModel{

    /**
     * 发送的标题
     */
    private String title;

    /**
     * 发送的内容
     */
    private String content;


}
