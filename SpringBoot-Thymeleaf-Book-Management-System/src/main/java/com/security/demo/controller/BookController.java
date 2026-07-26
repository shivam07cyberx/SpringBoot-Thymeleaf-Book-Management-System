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
import com.security.demo.service.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	BookService bs;
	
	@Autowired
	UserService ur;
	
	
	@GetMapping("/add-form")
	public String addBook() {
		
		return "addBook";
	}
	
	@PostMapping("/save")
	public String add(@ModelAttribute Book book, RedirectAttributes rda) {
		
		Integer avl=book.getBookCount();
		book.setAvailableBookCount(avl);
	
		rda.addFlashAttribute("msg", "book added successfully");
		
		bs.addBook(book);
		
		return "redirect:/books/add-form";
		
		
		
		
		
	}
	
	
	@GetMapping("/view")
	public String viewAllBook(Model model) {
		
		model.addAttribute("books", bs.viewAllBook());
		model.addAttribute("books", bs.viewAllBook());

		
		return "view-book";
	}
	
	
	
	
	@GetMapping("/search")
	public String searchBooks(@RequestParam String keyword, Model model) {

	    model.addAttribute("books", bs.searchBooks(keyword));
	    model.addAttribute("keyword", keyword);

	    return "view-book";
	}
	
	
	@GetMapping("/view_books")
	public String view_books(@RequestParam Long id, Model model) {
		
		
		model.addAttribute("books", bs.getBooks());
		model.addAttribute("user", ur.getById(id));

		
		return "user_book_view";
		
	}
	

	

}
