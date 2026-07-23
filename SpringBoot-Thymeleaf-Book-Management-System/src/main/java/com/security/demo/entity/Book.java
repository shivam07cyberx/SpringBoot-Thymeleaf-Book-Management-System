package com.security.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="library_book")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@NonNull
	private String bookname;
	@NonNull

	private String title;
	@NonNull

	private String description;
	@NonNull

	private String price;
	
	

}
