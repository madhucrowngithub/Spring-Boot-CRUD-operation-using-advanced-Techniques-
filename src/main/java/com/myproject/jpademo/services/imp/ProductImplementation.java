package com.myproject.jpademo.services.imp;

import com.myproject.jpademo.commons.Utils.Util;
import com.myproject.jpademo.commons.error.custom.EntityNotFoundException;
import com.myproject.jpademo.core.dto.CreateProductDto;
import com.myproject.jpademo.core.dto.ProductDto;
import com.myproject.jpademo.core.dto.mapper.CreateProductMapper;
import com.myproject.jpademo.core.dto.mapper.ProductMapper;
import com.myproject.jpademo.models.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myproject.jpademo.repository.ProductRepo;
import com.myproject.jpademo.services.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Log4j2
@Service
public class ProductImplementation implements ProductService {
	@Autowired
	public ProductRepo repos;
	@Autowired
	ProductMapper productMapper;
	@Autowired
	CreateProductMapper createProductMapper;

	@Override
	public ProductDto getProduct(int id) {
		Optional<Product> obj = null;
		try{
			obj = repos.getById(id);
			return obj.map(productMapper::toDto).orElse(null);
		}catch (Exception ex){
			return null;
		}
	}

	@Override
	public ProductDto addProduct(CreateProductDto createProductDto) {
		Product obj = createProductMapper.toEntity(createProductDto);
		obj.setToken(Util.getHash(obj.getName(), obj.getSerialNumber()));
		return productMapper.toDto(repos.save(obj));
	}

	@Override
	public void deleteProduct(int id) {
		repos.deleteById(id);
		log.info("deleting the product by id : {}",id);
	}

	@Override
	public ProductDto updateProduct(CreateProductDto createProductDto) {
		Product obj = createProductMapper.toEntity(createProductDto);
		obj.setToken(Util.getHash(obj.getName(), obj.getSerialNumber()));
		return productMapper.toDto(repos.save(obj));
	}



	@Override
	public Page<ProductDto> getProducts(int page, int size) {
		Sort sort = Sort.by("id");
		PageRequest pageRequest = PageRequest.of(page, size, sort);
		Page<Product> pages = repos.findAll(pageRequest);

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		return pages.map(productMapper::toDto);

	}
}