package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="author")
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;
	private String aname;
	
	@JsonIgnore
	@OneToMany( mappedBy = "author")
	private List<Book> bookList;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(int aId, String aname) {
		super();
		this.aId = aId;
		this.aname = aname;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public void addBook(Book book) {
		this.bookList.add(book);
	}

	@Override
	public String toString() {
		return "Author [aId=" + aId + ", aname=" + aname ;
	}
	
	
}
