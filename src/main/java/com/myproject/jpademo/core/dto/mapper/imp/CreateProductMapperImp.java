package com.myproject.jpademo.core.dto.mapper.imp;

import com.myproject.jpademo.core.dto.CreateProductDto;
import com.myproject.jpademo.core.dto.mapper.CreateProductMapper;
import com.myproject.jpademo.models.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
@Log4j2
@Component
public class CreateProductMapperImp implements CreateProductMapper {
    @Override
    public CreateProductDto toDto(Product product) {
    return null;
    }

    @Override
    public List<CreateProductDto> toDto(List<Product> products) {
        return null;
    }

    @Override
    public List<Product> toEntity(List<CreateProductDto> createProductDtos) {
        return null;
    }

    @Override
    public Set<CreateProductDto> toDto(Set<Product> products) {
        return null;
    }

    @Override
    public Set<Product> toEntity(Set<CreateProductDto> createProductDtos) {
        return null;
    }

    @Override
    public Product toEntity(CreateProductDto obj) {
        if( obj == null){
            return null;
        }
        Product product = new Product();
        product.setId(obj.getId());
        product.setName(obj.getName());
        product.setSerialNumber(obj.getSerialNumber());
        log.info("sending data to update : {}",product);
        return product;
    }
}
