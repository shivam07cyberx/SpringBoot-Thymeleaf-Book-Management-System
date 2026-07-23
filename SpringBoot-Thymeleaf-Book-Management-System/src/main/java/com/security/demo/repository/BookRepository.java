package com.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.demo.entity.Book;
import java.util.List;


public interface BookRepository  extends JpaRepository<Book, Long>{

	
	List<Book> findByBooknameContainingIgnoreCase(String bookname);
	
	
	
}
