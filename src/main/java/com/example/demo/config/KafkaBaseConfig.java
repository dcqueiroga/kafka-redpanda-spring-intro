package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;

public abstract class KafkaBaseConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    protected String bootstrapAddress;
}
