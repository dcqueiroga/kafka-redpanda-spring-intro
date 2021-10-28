package com.example.demo.config;

import com.example.demo.util.Constants;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress
        );
        return new KafkaAdmin(configProperties);
    }

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic(Constants.TOPIC, Constants.NUM_PARTITIONS, Constants.REPLICATION_FACTOR);
    }
}
