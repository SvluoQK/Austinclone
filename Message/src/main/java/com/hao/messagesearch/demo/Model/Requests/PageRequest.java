package com.hao.messagesearch.demo.Model.Requests;

import lombok.Data;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
public class PageRequest {
    private static final long serialVersionUID = -9081656336751681819L;

    /**
     * 当前的页号
     *
     */
    private int pageNum = 1;

    /**
     *
     * 页面大小
     */
    private int pageSize = 10;


}
