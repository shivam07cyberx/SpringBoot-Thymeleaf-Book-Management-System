package com.security.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.demo.entity.Book;
import com.security.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository br;
	
	public Book addBook(Book book) {
		

		
		
		return br.save(book);
	}
	
	
	public List<Book> viewAllBook(){
		
		
		return br.findAll();
		
		
		
	}
	
	public List<Book> searchBooks(String keyword){

	    return br
	            .findByBooknameContainingIgnoreCase(keyword);

	}
	
	
	public List<Book> getBooks(){
		
		return br.findAll();
	}
	

	public Book findBookById(Long id) {
		
		return br.findById(id).get();
	}
	
	
	public Book updateBookCount(Book book) {
		return br.save(book);
	}
	
}
