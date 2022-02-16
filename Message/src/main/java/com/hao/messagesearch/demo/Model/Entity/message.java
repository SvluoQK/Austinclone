package com.hao.messagesearch.demo.Model.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

@TableName("message")
public class message {
    /**
     * message实体类
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer ID;
    @TableField(value = "message")
    private String message;

}
