package com.hao.austinclone.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Component
@Slf4j
public class KafkaUtil {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     *
     * @param topicName
     * @param JsonMessage 用来发送kafka消息的
     *
     */
    public void send(String topicName, String JsonMessage){
        kafkaTemplate.send(topicName,JsonMessage);
    }

}
