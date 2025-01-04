package com.myproject.jpademo.services.imp;

import com.myproject.jpademo.services.KafkaProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class KafkaProducerServiceImp implements KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topicName;

    @Override
    public void sendMessage(String key,String msg) {
        kafkaTemplate.send(topicName, key, msg);


    }
}
