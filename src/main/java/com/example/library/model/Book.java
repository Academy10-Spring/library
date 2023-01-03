package com.example.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "books")
public class Book {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	
	public Book() {
		
	}
	
	public Book(String title, String isbn) {
		
		this.title = title;
		this.isbn = isbn;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
}
