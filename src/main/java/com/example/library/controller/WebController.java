package com.example.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.library.form.FormAuthor;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;

@Controller
public class WebController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@GetMapping("/")
	public String getHome(Model model) {
		
		List<Book> bookList = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", bookList);
		return "home";
	}
	
	@GetMapping("/author")
	public String getFormAuthor(FormAuthor authorForm, Model model) {
		model.addAttribute("authorForm", authorForm);
		return "author/form";
	}
	
	@PostMapping("/addAuthor")
	public String addAuthor(@Valid @ModelAttribute("authorForm") FormAuthor authorForm, BindingResult bindingResult, Model model) {
	
		if(bindingResult.hasErrors()) {
			
			return "author/form";
		}
		
		authorRepository.save(authorForm.getAuthor());
		return "redirect:/";
	}

	@GetMapping("/book")
	public String getFormBook(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		return "book/form";
	}
}
