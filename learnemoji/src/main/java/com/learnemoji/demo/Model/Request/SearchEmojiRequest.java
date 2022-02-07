package com.learnemoji.demo.Model.Request;

import com.learnemoji.demo.Base.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SearchEmojiRequest extends PageRequest {

    /**
     * 搜索表情的名字
     *
     */
    private String name;

    private String tag;

    private Integer reviewStatus;



}
