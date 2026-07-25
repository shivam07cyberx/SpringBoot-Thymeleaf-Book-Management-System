package com.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.entity.Borrow;
import com.security.demo.repository.BorrowRepository;

@Service
public class BorrowService {
	
	@Autowired
	BorrowRepository br;
	
	
	
	public List<Borrow> showBorrow(){
		
		return br.findAll();
	}
	
	
	
	public Borrow add(Borrow borrow) {
		
		return br.save(borrow);
	}
	
	

}
