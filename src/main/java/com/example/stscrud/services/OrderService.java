package com.example.stscrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stscrud.entities.Order;
import com.example.stscrud.repositories.OrderRepository;

@Service
public class OrderService  {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> fidAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj  = repository.findById(id);
		return obj.get();
	}
}
