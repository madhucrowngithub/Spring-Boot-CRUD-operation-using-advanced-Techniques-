package com.myproject.jpademo.core.dto.mapper;

import com.myproject.jpademo.commons.mappers.IEntityMapper;
import com.myproject.jpademo.commons.mappers.IEntityMapperFromDto;
import com.myproject.jpademo.core.dto.CreateProductDto;
import com.myproject.jpademo.models.Product;

public interface CreateProductMapper extends IEntityMapper<CreateProductDto, Product> {
}

