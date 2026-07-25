package com.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.entity.User;
import com.security.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	PasswordEncoder pencode;
	
	public String register(User user) {
		
		
		user.setRole("USER");
		
		user.setPassword(pencode.encode(user.getPassword()));
		
		ur.save(user);
		
		
		
		return "added";
		
		
	}
	
	
	
	public List<User> getUsers() {
		return ur.findAll();
		
	}
	
	
	
	
	public User getById(Long id) {
		
		
		return ur.findById(id).get();
	}
	
	
	public User  getByUserName(String name) {
		
		
		return ur.findByUsername(name).get();
	}
	

}
