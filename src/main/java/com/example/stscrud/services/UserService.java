package com.example.stscrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stscrud.entities.User;
import com.example.stscrud.repositories.UserRepository;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> fidAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj  = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete( Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		uptdateData(entity,obj);
		return repository.save(entity);
	}

	private void uptdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
