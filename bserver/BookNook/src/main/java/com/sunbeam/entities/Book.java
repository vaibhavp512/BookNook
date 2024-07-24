package com.sunbeam.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="book")
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bId;
	private String bname;
	private Double bprice;
	private int bpages;
	private int bavCopies;
	private int btCopies;
	private String bfront;
	private String bback;
	private int brating;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp;
	@ManyToOne
	@JoinColumn(name = "authId", referencedColumnName = "aId")
	private Author author;
	@ManyToOne
	@JoinColumn(name = "publiId", referencedColumnName = "pubId")
	private Publisher publisher;
	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "catId")
	private Categories category;
	
	@ManyToMany(mappedBy = "bookCart", fetch = FetchType.LAZY)
	private List<Order>orderdetails;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bId, String bname, Double bprice, int bpages, int bavCopies, int btCopies, String bfront,
			String bback, int brating, Date createdTimestamp, Author author, Publisher publisher, Categories category) {
		super();
		this.bId = bId;
		this.bname = bname;
		this.bprice = bprice;
		this.bpages = bpages;
		this.bavCopies = bavCopies;
		this.btCopies = btCopies;
		this.bfront = bfront;
		this.bback = bback;
		this.brating = brating;
		this.createdTimestamp = createdTimestamp;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Double getBprice() {
		return bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public int getBpages() {
		return bpages;
	}

	public void setBpages(int bpages) {
		this.bpages = bpages;
	}

	public int getBavCopies() {
		return bavCopies;
	}

	public void setBavCopies(int bavCopies) {
		this.bavCopies = bavCopies;
	}

	public int getBtCopies() {
		return btCopies;
	}

	public void setBtCopies(int btCopies) {
		this.btCopies = btCopies;
	}

	public String getBfront() {
		return bfront;
	}

	public void setBfront(String bfront) {
		this.bfront = bfront;
	}

	public String getBback() {
		return bback;
	}

	public void setBback(String bback) {
		this.bback = bback;
	}

	public int getBrating() {
		return brating;
	}

	public void setBrating(int brating) {
		this.brating = brating;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bname=" + bname + ", bprice=" + bprice + ", bpages=" + bpages + ", bavCopies="
				+ bavCopies + ", btCopies=" + btCopies + ", bfront=" + bfront + ", bback=" + bback + ", brating="
				+ brating + ", createdTimestamp=" + createdTimestamp + ", author=" + author + ", publisher=" + publisher
				+ ", category=" + category;
	}
		
}
