package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.security.demo.entity.Book;
import com.security.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	BookService bs;
	
	
	
	
	@GetMapping("/add-form")
	public String addBook() {
		
		return "addBook";
	}
	
	@PostMapping("/save")
	public String add(@ModelAttribute Book book, RedirectAttributes rda) {
		
		
	
		rda.addFlashAttribute("msg", "book added successfully");
		
		bs.addBook(book);
		
		return "redirect:/books/add-form";
		
		
		
		
		
	}
	
	
	@GetMapping("/view")
	public String viewAllBook(Model model) {
		
		model.addAttribute("books", bs.viewAllBook());
		
		
		return "view-book";
	}
	
	
	
	
	@GetMapping("/search")
	public String searchBooks(@RequestParam String keyword, Model model) {

	    model.addAttribute("books", bs.searchBooks(keyword));
	    model.addAttribute("keyword", keyword);

	    return "view-book";
	}
	
	
	

}
