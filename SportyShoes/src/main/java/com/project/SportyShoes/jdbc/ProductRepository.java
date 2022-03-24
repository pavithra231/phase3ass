package com.project.SportyShoes.jdbc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.SportyShoes.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> save(String productName);

}
