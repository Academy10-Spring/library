package com.example.library.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "authors")
public class Author {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstname;
	
	private String lastname;
	
	@OneToMany(mappedBy = "author")
	private Set<Book> bookSet = new HashSet<>();


	public Author() {
		
	}
	
	public Author(String firstname, String lastname) {
		
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
}
