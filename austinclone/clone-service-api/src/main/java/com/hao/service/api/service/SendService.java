package com.hao.service.api.service;

import com.hao.service.api.domain.BatchSendRequest;
import com.hao.service.api.domain.SendRequest;
import com.hao.service.api.domain.SendResponse;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */


public interface SendService {
    /**
     * 发送文案
     */
    SendResponse send(SendRequest sendRequest);

    /**
     * 多文案发送
     */
    SendResponse batchSend(BatchSendRequest batchSendRequest);


}
