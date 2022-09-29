package com.tweetApp.comp2.Config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import lombok.Generated;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@Generated

@Service
public class KafkaConsumerConfig {

    @KafkaListener(topics = "message", groupId = "tweetApp")
    public void consume(String message) {
        System.out.println("message received" + message);
        log.info(String.format("Message received -> %s", message));
    }
}