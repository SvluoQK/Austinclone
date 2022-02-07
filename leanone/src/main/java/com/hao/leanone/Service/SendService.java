package com.hao.leanone.Service;

import com.hao.leanone.Base.BatchSendRequest;
import com.hao.leanone.Base.SendRequest;
import com.hao.leanone.Base.SendResponse;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */


public interface SendService {

    /**
     * 单文案发送
     *
     */
    public SendResponse send(SendRequest sendRequest);


    SendResponse batchSend(BatchSendRequest batchSendRequest);






}
