package com.security.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.demo.entity.User;


public interface UserRepository  extends JpaRepository<User, Long>{
	
	
	public Optional<User>  findByUsername(String username);

}
