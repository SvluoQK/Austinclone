package com.hao.messagesearch.demo.Model.Requests;

import lombok.Data;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
public class SearchMessageRequest extends PageRequest{

    private String message;

    private int ID;


}
