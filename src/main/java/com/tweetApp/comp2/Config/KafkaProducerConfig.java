package com.tweetApp.comp2.Config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service

@Slf4j

@Configuration
public class KafkaProducerConfig {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message) {
        log.info(String.format("Message sent-> %s", message));
//        this.kafkaTemplate.send("message", "message", message);
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic("message", 3, (short) 1);
    }

}
