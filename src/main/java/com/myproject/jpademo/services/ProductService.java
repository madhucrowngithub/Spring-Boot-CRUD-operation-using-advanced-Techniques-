package com.myproject.jpademo.services;

import java.util.List;

import com.myproject.jpademo.core.dto.CreateProductDto;
import com.myproject.jpademo.core.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.myproject.jpademo.models.Product;


public interface ProductService {
	
	ProductDto getProduct(int id);

	ProductDto addProduct(CreateProductDto createProductDto);

	void deleteProduct(int id);

	ProductDto updateProduct(CreateProductDto createProductDto);

	Page<ProductDto> getProducts(int page, int size);


	

}
