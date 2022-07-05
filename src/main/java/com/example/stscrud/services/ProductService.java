package com.example.stscrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stscrud.entities.Product;
import com.example.stscrud.repositories.ProductRepository;

@Service
public class ProductService  {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> fidAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj  = repository.findById(id);
		return obj.get();
	}
}
