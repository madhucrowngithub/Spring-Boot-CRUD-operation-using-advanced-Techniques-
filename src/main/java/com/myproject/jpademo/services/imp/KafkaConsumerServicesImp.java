package com.myproject.jpademo.services.imp;

import com.myproject.jpademo.commons.Utils.Util;
import com.myproject.jpademo.core.dto.EventQueueDto;
import com.myproject.jpademo.core.dto.mapper.CreateEventMapper;
import com.myproject.jpademo.models.EventQueue;
import com.myproject.jpademo.repository.EventQueueRepo;
import com.myproject.jpademo.services.KafkaConsumerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;



@Service
@Log4j2
public class KafkaConsumerServicesImp implements KafkaConsumerService {

    @Autowired
    private EventQueueRepo eventQueueRepo;
@Autowired
    private CreateEventMapper createEventMapper;


    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.group-id}")
    public void listen(@Header(KafkaHeaders.RECEIVED_KEY) String key,String message) {
        EventQueueDto eventQueueDto = new EventQueueDto();
        eventQueueDto.setEventMessage(message);
        eventQueueDto.setEventKey(key);
        eventQueueDto.setToken(Util.getHash(message,"normal"));
        eventQueueRepo.save(createEventMapper.toEntity(eventQueueDto));
        final String consumeMessage = String.format("Saved Messasge to DB : [%s=%s] ", key, message);
        log.info(consumeMessage);
    }
}
