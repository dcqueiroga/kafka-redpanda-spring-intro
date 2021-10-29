package com.example.demo.controller;

import com.example.demo.messaging.KafkaPublisher;
import com.example.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaPublisher kafkaPublisher;

    @PostMapping("publish")
    public ResponseEntity<String> publishMessage(@RequestParam String message) {
        try {
            kafkaPublisher.sendMessage(Constants.TOPIC, message);
            return ResponseEntity.ok(null);
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getLocalizedMessage());
        }
    }
}
