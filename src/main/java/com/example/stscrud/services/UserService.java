package com.example.stscrud.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.stscrud.entities.User;
import com.example.stscrud.repositories.UserRepository;
import com.example.stscrud.resources.exceptions.DatabaseException;
import com.example.stscrud.services.exceptions.ResourceNotFoundException;

@Service
public class UserService  {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> fidAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj  = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete( Long id) {
		try {			
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			uptdateData(entity,obj);
			return repository.save(entity);			
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void uptdateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
