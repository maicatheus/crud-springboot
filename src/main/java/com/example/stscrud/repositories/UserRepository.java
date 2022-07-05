package com.example.stscrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stscrud.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
	
	
}
