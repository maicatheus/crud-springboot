package com.example.stscrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stscrud.entities.Category;
import com.example.stscrud.repositories.CategoryRepository;

@Service
public class CategoryService  {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> fidAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj  = repository.findById(id);
		return obj.get();
	}
}
