package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="orders")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	
	private int uid;
	private int did;
	private String ostatus;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date odate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date oreturnDate;
//	
//	@ManyToOne
//	@JoinColumn(name = "delId", referencedColumnName = "uId")
//	private Customer delivery;

	@ManyToMany
    @JoinTable(
            name = "orderDetails",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "bookId")
    )
	private List<Book> bookCart = new ArrayList<Book>();

	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	

	public Order(int oid, int uid, int did, String ostatus, Date odate, Date oreturnDate, List<Book> bookCart) {
		this.oid = oid;
		this.uid = uid;
		this.did = did;
		this.ostatus = ostatus;
		this.odate = odate;
		this.oreturnDate = oreturnDate;
		this.bookCart = bookCart;
	}



	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}

	

	public int getDid() {
		return did;
	}



	public void setDid(int did) {
		this.did = did;
	}



	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}

	public Date getOreturnDate() {
		return oreturnDate;
	}

	public void setOreturnDate(Date oreturnDate) {
		this.oreturnDate = oreturnDate;
	}

	public List<Book> getBookCart() {
		return bookCart;
	}

	public void setBookCart(List<Book> bookCart) {
		this.bookCart = bookCart;
	}

	public void addToCart(Book b) {
		this.bookCart.add(b);
	}



	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", did=" + did + ", ostatus=" + ostatus + ", odate=" + odate
				+ ", oreturnDate=" + oreturnDate + ", bookCart=" + bookCart + "]";
	}

	
}
