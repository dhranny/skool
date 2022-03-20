package com.skool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class ProducerConfig {

    @Value(value = "${kafka.boostrapAddress}")
    private String bootstrapAddress
    @Bean
    private ProducerFactory<String, String> producerFactory(){
        Map configMap = new HashMap<String, String>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_ADDRESS, bootstrapAddress);

    }
}
