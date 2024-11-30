package com.myproject.jpademo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.jpademo.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	Page<Product> findAll(Pageable pageable);
	Optional<Product> getById(int id);

}
