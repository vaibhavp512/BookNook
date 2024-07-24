package com.sunbeam.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="categories")
@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	private String catname;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category",orphanRemoval = true)
	private List<Book> bookList;
	
	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(int catId, String catname, List<Book> bookList) {
		super();
		this.catId = catId;
		this.catname = catname;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
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
		return "Categories [catId=" + catId + ", catname=" + catname;
	}
	
}
