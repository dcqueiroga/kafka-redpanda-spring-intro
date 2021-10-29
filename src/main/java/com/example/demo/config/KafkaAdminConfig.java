package com.example.demo.config;

import com.example.demo.util.Constants;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaAdminConfig extends KafkaBaseConfig {

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
