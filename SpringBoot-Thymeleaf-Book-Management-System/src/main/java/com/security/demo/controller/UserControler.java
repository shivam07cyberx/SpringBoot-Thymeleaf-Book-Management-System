package com.security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.demo.entity.User;
import com.security.demo.service.UserService;

@Controller
public class UserControler {
	
	@Autowired
	UserService ur;

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
	    
	    
	    
	    
	    
//	    System.out.println(user);
//	    
//	    
//	   System.out.println(ur.getUsers());

	    return "dashboard";
	}
	
	
	
	
	
	
}
