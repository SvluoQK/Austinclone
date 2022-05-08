package com.hao.austincloneapi.domain;

import com.hao.service.api.domain.MessageParam;
import com.java3y.austin.common.domain.TaskInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel {
    /**
     * 消息模板Id
     */
    private Long messageTemplateId;

    /**
     * 请求参数
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务的信息
     */
    private List<TaskInfo> taskInfo;
}
