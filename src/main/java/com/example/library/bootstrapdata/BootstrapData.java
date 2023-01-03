package com.example.library.bootstrapdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Author authorMario = new Author("Mario", "Rossi");
		Author authorGiorgio = new Author("Giorgio", "Bianchi");
		
		Book bookMario1 = new Book("Il mio primo libro", "12345");
		bookMario1.setAuthor(authorMario);
		authorMario.getBookSet().add(bookMario1);
		
		Book bookGiorgio1 = new Book("Il libro di Giorgio", "54321");
		bookGiorgio1.setAuthor(authorGiorgio);
		authorGiorgio.getBookSet().add(bookGiorgio1);
		
		authorRepository.save(authorMario);
		authorRepository.save(authorGiorgio);
		
		bookRepository.save(bookMario1);
		bookRepository.save(bookGiorgio1);
	}

}
