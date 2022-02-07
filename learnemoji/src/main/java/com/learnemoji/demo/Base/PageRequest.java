package com.learnemoji.demo.Base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 分页查询的请求
 */


@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -9081656336751681819L;

    /**
     * 当前页号
     *
     */
    private int PageNum =1;

    /**
     * 页面大小
     *
     */
    private int PageSize=10;



}
