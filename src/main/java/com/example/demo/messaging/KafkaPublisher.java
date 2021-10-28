package com.example.demo.messaging;

import com.example.demo.config.KafkaProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher {

    @Autowired
    private KafkaProducerConfig producerConfig;

    public void sendMessage(String topic, String message) {
        producerConfig.kafkaTemplate().send(topic, message);
    }
}
