package com.myproject.jpademo.core.dto.mapper;

import com.myproject.jpademo.commons.mappers.IEntityMapper;
import com.myproject.jpademo.core.dto.CreateProductDto;
import com.myproject.jpademo.core.dto.EventQueueDto;
import com.myproject.jpademo.models.EventQueue;
import com.myproject.jpademo.models.Product;

public interface CreateEventMapper extends IEntityMapper<EventQueueDto, EventQueue> {
}
