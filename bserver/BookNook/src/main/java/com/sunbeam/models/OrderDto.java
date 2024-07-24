package com.sunbeam.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.Order;

@Component
public class OrderDto {
	
    private int oid;
	private int uid;
	private int did;
	private String ostatus;
	@Temporal(TemporalType.TIMESTAMP)
	private String odate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private String oreturnDate;
	
	private List<Book> bookCart;
	
	private List<Customer> clist;
	
	public OrderDto() {
		
	}

	public OrderDto(int oid, int uid, int did, String ostatus, String odate, String oreturnDate, List<Book> bookCart,
			List<Customer> clist) {
		this.oid = oid;
		this.uid = uid;
		this.did = did;
		this.ostatus = ostatus;
		this.odate = odate;
		this.oreturnDate = oreturnDate;
		this.bookCart = bookCart;
		this.clist = clist;
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



	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String string) {
		this.odate = string;
	}

	public String getOreturnDate() {
		return oreturnDate;
	}

	public void setOreturnDate(String oreturnDate) {
		this.oreturnDate = oreturnDate;
	}

		
	
	public List<Book> getBookCart() {
		return bookCart;
	}



	public void setBookCart(List<Book> bookCart) {
		this.bookCart = bookCart;
	}

	


	public int getDid() {
		return did;
	}




	public void setDid(int did) {
		this.did = did;
	}

	public List<Customer> getClist() {
		return clist;
	}

	public void setClist(List<Customer> clist) {
		this.clist = clist;
	}

	public static OrderDto fromEntity(Order entity) {
		OrderDto dto = new OrderDto();
		BeanUtils.copyProperties(entity, dto);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		dto.setOdate(formatter.format(entity.getOdate()));
		dto.setOreturnDate(formatter.format(entity.getOreturnDate()));
		return dto;
	}
	
	public static Order toEntity(OrderDto dto) {
		Order entity = new Order();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	
	
}
