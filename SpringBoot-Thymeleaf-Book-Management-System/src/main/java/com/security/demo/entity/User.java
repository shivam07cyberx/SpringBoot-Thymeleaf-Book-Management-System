package com.security.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="library_user")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String username;
	@NonNull
	private String password;
	
	
	private String role;
	
	@NonNull
	private String mobile;
	
	
	@OneToMany(mappedBy = "user",
	           cascade = CascadeType.ALL,
	           fetch = FetchType.LAZY)
	private List<Borrow> borrows;
}
