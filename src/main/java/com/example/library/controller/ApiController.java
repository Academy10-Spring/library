package com.example.library.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;

@RestController
@RequestMapping("api")
public class ApiController {
	
	@Autowired private AuthorRepository authorRepository;
	
	@Autowired private BookRepository bookRepository;

	@PostMapping(value = "/addBook")
	public boolean addBook(@RequestParam Map<String, String> params) {
		
		// {title=Prova, isbn=Demo, author=1}
		try {
			Book book = new Book(params.get("title"), params.get("isbn"));
			long author_id = Long.parseLong(params.get("author"));
		
			Author author = authorRepository.findById(author_id).orElse(null);
			if(author != null) {
				book.setAuthor(author);
				bookRepository.save(book);
				return true;
			}
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return false;
	}
}
