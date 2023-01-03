package com.example.library.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.library.model.Author;

public class FormAuthor {

	private long id;
	
	@NotEmpty
	@Size(min = 2, max = 30)
	private String firstname;
	
	@NotEmpty
	@Size(min = 2, max = 30)
	private String lastname;
	
	
	public FormAuthor() {
		
	}
	
	public Author getAuthor() {
		
		Author author = new Author();
		author.setId(id);
		author.setFirstname(firstname);
		author.setLastname(lastname);
		return author;
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
}
