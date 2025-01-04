package com.myproject.jpademo.controller;

import com.myproject.jpademo.commons.dto.Response;
import com.myproject.jpademo.commons.dto.RestResponseEntity;
import com.myproject.jpademo.core.dto.CreateProductDto;
import com.myproject.jpademo.core.dto.ProductDto;
import com.myproject.jpademo.services.KafkaProducerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myproject.jpademo.services.imp.ProductImplementation;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/v1/product")
public class ProductController {
	@Autowired
	ProductImplementation services;
	@Autowired
	private KafkaProducerService producer;


@Operation(summary = "Get Product by Id")
	@GetMapping("/{id}")
	public ResponseEntity<Response<ProductDto>> getProduct(@PathVariable int id) {
		log.info("Got path variable as : {}",id);
		log.info("got response as : {}", services.getProduct(id));
		ProductDto obj =  services.getProduct(id);
		if(obj != null){
			return RestResponseEntity.getResponse(Response.<ProductDto>ok()
					.setPayload(services.getProduct(id)), HttpStatus.OK);
		}
		return RestResponseEntity.getResponse(Response.<ProductDto>notFound()
				.setPayload(services.getProduct(id)), HttpStatus.OK);
	}
@Operation(summary = "create product")
	@PostMapping
	public ResponseEntity<Response<ProductDto>> createProduct(@RequestBody CreateProductDto createProductDto){
		log.info("got request with data : {}",createProductDto);
		return RestResponseEntity.getResponse(Response.<ProductDto>ok()
				.setPayload(services.addProduct(createProductDto)), HttpStatus.CREATED);
	}
@Operation(summary = "update the product")
	@PutMapping
	public ResponseEntity<Response<ProductDto>> updateProduct(@RequestBody CreateProductDto createProductDto){
		log.info("got data for updating : {}",createProductDto);
		return RestResponseEntity.getResponse(Response.<ProductDto>ok()
				.setPayload(services.updateProduct(createProductDto)),HttpStatus.CREATED);
	}
@Operation(summary = "delete product by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<String>> removeProduct(@PathVariable int id){
		services.deleteProduct(id);
		return RestResponseEntity.getResponse(Response.<String>ok()
				.setPayload(String.format("Product got deleted for the id %s",id)),HttpStatus.OK);
	}
@Operation(summary = "get all the product details")
	@GetMapping
	public ResponseEntity<Response<List<ProductDto>>> getProducts(@RequestParam(required = false, defaultValue = "0") Integer page,
																  @RequestParam(required = false, defaultValue = "10") Integer size){
		Page<ProductDto> pages = services.getProducts(page, size);
		Response.PageMetadata metadata = new Response
				.PageMetadata(pages.getSize(),
				pages.getTotalElements(), pages.getTotalPages(), pages.getNumber());
		Response<List<ProductDto>> response = Response.<List<ProductDto>>ok()
				.setPayload(pages.toList())
				.setMetadata(metadata);
		return RestResponseEntity.getResponse(response,HttpStatus.OK);
	}

	@Operation(summary = "publishing data to kafka")
	@PostMapping("/send-message")
	public ResponseEntity<Response<String>> pushDataToKafka(@RequestParam String key,
															@RequestParam String message){
	producer.sendMessage(key,message);
		return RestResponseEntity.getResponse(Response.<String>ok()
				.setPayload(String.format("message send to kafka %s=%s",key,message)),HttpStatus.OK);

	}
}



