package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="publisher")
@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pubId;
	private String pubname;
	
	@JsonIgnore
	@OneToMany( mappedBy = "publisher")
	private List<Book> bookList;
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}
	
	public Publisher(int pubId, String pubname) {
		this.pubId = pubId;
		this.pubname = pubname;
	}
	public int getPubId() {
		return pubId;
	}
	public void setPubId(int pubId) {
		this.pubId = pubId;
	}
	public String getPubname() {
		return pubname;
	}
	public void setPubname(String pubname) {
		this.pubname = pubname;
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
		return "Publisher [pubId=" + pubId + ", pubname=" + pubname ;
	}
	
	
	
}
