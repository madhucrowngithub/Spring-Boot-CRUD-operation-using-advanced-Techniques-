package com.myproject.jpademo.core.dto.mapper.imp;

import com.myproject.jpademo.core.dto.ProductDto;
import com.myproject.jpademo.core.dto.mapper.ProductMapper;
import com.myproject.jpademo.models.Product;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDto toDto(Product p) {
        if( p == null){
            return null;
        }

        ProductDto obj = new ProductDto();

        obj.setId(p.getId());
        obj.setName(p.getName());
        obj.setToken(p.getToken());
        obj.setSerialNumber(p.getSerialNumber());
        obj.setCreatedDate(LocalDateTime.now(Clock.systemDefaultZone()));
        obj.setUpdatedDate(LocalDateTime.now(Clock.systemDefaultZone()));

        return obj;
    }

    @Override
    public Product toEntity(ProductDto obj){
        if( obj == null){
            return null;
        }

        Product product = new Product();
        product.setId(obj.getId());
        product.setName(obj.getName());
        product.setSerialNumber(obj.getSerialNumber());
        return product;
    }

    @Override
    public List<ProductDto> toDto(List<Product> products) {
        return null;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> productDtos) {
        return null;
    }

    @Override
    public Set<ProductDto> toDto(Set<Product> products) {
        return null;
    }

    @Override
    public Set<Product> toEntity(Set<ProductDto> productDtos) {
        return null;
    }
}
