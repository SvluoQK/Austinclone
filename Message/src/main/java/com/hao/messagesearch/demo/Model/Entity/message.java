package com.hao.messagesearch.demo.Model.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
@Component
@AllArgsConstructor
@TableName("message")
public class message {
    /**
     * message实体类
     */
    private int ID;
    private String message;

}
