package com.myproject.jpademo.core.dto.mapper.imp;

import com.myproject.jpademo.core.dto.EventQueueDto;
import com.myproject.jpademo.core.dto.mapper.EventQueueMapper;
import com.myproject.jpademo.models.EventQueue;

import java.util.List;
import java.util.Set;

public class EventQueueMapperImp implements EventQueueMapper {
    @Override
    public EventQueueDto toDto(EventQueue eventQueue) {
        return null;
    }

    @Override
    public List<EventQueueDto> toDto(List<EventQueue> eventQueues) {
        return null;
    }

    @Override
    public List<EventQueue> toEntity(List<EventQueueDto> EventQueueDtos) {
        return null;
    }

    @Override
    public Set<EventQueueDto> toDto(Set<EventQueue> eventQueues) {
        return null;
    }

    @Override
    public Set<EventQueue> toEntity(Set<EventQueueDto> EventQueueDtos) {
        return null;
    }

    @Override
    public EventQueue toEntity(EventQueueDto eventQueueDto) {
        return null;
    }
}
