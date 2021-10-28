package com.example.demo.messaging;

import com.example.demo.util.Constants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = Constants.TOPIC, groupId = Constants.GROUP_ID)
    public void listenGroupFoo(String message) {
        System.out.println("Received message in group " + Constants.GROUP_ID + ": " + message);
    }
}
