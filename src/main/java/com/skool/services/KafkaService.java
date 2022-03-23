package com.skool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafTemp;

    public void send(String topic, String record){
        kafTemp.send(topic, record);
        kafTemp.flush();
    }


}
