package com.myproject.jpademo.core.dto.mapper;

import com.myproject.jpademo.commons.mappers.IEntityMapper;
import com.myproject.jpademo.core.dto.ProductDto;
import com.myproject.jpademo.models.Product;

public interface ProductMapper extends IEntityMapper<ProductDto, Product> {
}