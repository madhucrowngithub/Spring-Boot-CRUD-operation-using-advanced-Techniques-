package com.myproject.jpademo.core.dto.mapper.imp;

import com.myproject.jpademo.core.dto.EventQueueDto;
import com.myproject.jpademo.core.dto.mapper.CreateEventMapper;
import com.myproject.jpademo.models.EventQueue;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
@Component
public class CreateEventMapperImp implements CreateEventMapper {
    @Override
    public EventQueueDto toDto(EventQueue eventQueue) {
        return null;
    }

    @Override
    public List<EventQueueDto> toDto(List<EventQueue> eventQueues) {
        return null;
    }

    @Override
    public List<EventQueue> toEntity(List<EventQueueDto> eventQueueDtos) {
        return null;
    }

    @Override
    public Set<EventQueueDto> toDto(Set<EventQueue> eventQueues) {
        return null;
    }

    @Override
    public Set<EventQueue> toEntity(Set<EventQueueDto> eventQueueDtos) {
        return null;
    }

    @Override
    public EventQueue toEntity(EventQueueDto obj) {
        if( obj == null){
            return null;
        }
        EventQueue eventQueue = new EventQueue();
        eventQueue.setId(obj.getId());
        eventQueue.setEventMessage(obj.getEventMessage());
        eventQueue.setEventKey(obj.getEventKey());
        eventQueue.setToken(obj.getToken());
        return eventQueue;
    }
}
