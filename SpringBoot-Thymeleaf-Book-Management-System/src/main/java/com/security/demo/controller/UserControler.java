package com.security.demo.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.demo.entity.Book;
import com.security.demo.entity.Borrow;
import com.security.demo.entity.User;
import com.security.demo.service.BookService;
import com.security.demo.service.BorrowService;
import com.security.demo.service.UserService;

@Controller
public class UserControler {
	
	@Autowired
	UserService ur;
	
	@Autowired
	BookService bs;
	
	
	@Autowired
	BorrowService br;

	@GetMapping("/")
	public String showWelcome() {
		
		return "welcome";
	}

	
	
	
	@GetMapping("/login")
	public String showLogin() {
		
		return "login";
	}
	
	
	@GetMapping("/register")
	public String showRegister() {
		
		return "register";
	}
	
	
	@PostMapping("/register_user")
	public String register(@ModelAttribute User user) {
		
		ur.register(user);
		
		
System.out.println(user);
		
		
		return "redirect:/login";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		
		

	    Authentication authentication =
	            SecurityContextHolder.getContext().getAuthentication();

	    UserDetails user = (UserDetails) authentication.getPrincipal();

	    model.addAttribute("username", user.getUsername());
	    model.addAttribute("roles", user.getAuthorities());
	    
	    
	    
	    List<Book> books= bs.viewAllBook();
		model.addAttribute("totalBooks", books.size());
		
		List<User> users=ur.getUsers();
		
		model.addAttribute("user", ur.getByUserName(user.getUsername()));
		
		model.addAttribute("totalUsers",users.size() );

		int availableBook = books.stream()
		        .map(book -> book.getAvailableBookCount() == null ? 0 : book.getAvailableBookCount())
		        .reduce(0, Integer::sum);		
		model.addAttribute("availableBooks", availableBook);
	    
	    
	    
//	    System.out.println(user);
//	    
//	    
//	   System.out.println(ur.getUsers());

	    return "dashboard";
	}
	
	
	
	@GetMapping("/users")
	public String viewAllUser(Model model) {
		
	model.addAttribute("users",ur.getUsers());
	
	return "view_users";
		
	}
	
	
	@GetMapping("/admin/user/{id}")
	public String viewUser(@PathVariable Long id,Model model) {
		
		
		
		
		
		User u=ur.getById(id);
		
		model.addAttribute("user", ur.getById(id));
		
		
		
		model.addAttribute("borrowedBooks", u.getBorrows());
		
		
		return "user_detail";
		
	}
	
	@PostMapping("/user/issue/{bookId}/{id}")
	public String issueBook(@PathVariable Long bookId, @PathVariable Long id) {
		
		Book book=bs.findBookById(bookId);
		User user=ur.getById(id);
		
		Borrow issuedBook =new Borrow();
		issuedBook.setBook(book);
		issuedBook.setUser(user);
		
		issuedBook.setBorrowDate(LocalDate.now());
		issuedBook.setDueDate(LocalDate.now().plusDays(7));
		
		issuedBook.setStatus("issued");
		
		issuedBook.setFine(0.0);
		
		
		br.add(issuedBook);
		
		return "redirect:/books/view_books?id="+user.getId();
		
		
		
	}
	
}
