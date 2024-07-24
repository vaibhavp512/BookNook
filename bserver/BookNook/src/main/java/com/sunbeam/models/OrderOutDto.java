package com.sunbeam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Order;

@Component
public class OrderOutDto {
	private int oid;
	private int uid;
	private String ostatus;
	@Temporal(TemporalType.TIMESTAMP)
	private Date odate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date oreturnDate;
	private String bname;
	
	public OrderOutDto() {
		// TODO Auto-generated constructor stub
	}

	public OrderOutDto(int oid, int uid, String ostatus, Date odate, Date oreturnDate, String bname) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.ostatus = ostatus;
		this.odate = odate;
		this.oreturnDate = oreturnDate;
		this.bname = bname;
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

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public static OrderOutDto fromEntity(Order entity) {
		OrderOutDto dto = new OrderOutDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public static Order toEntity(OrderOutDto dto) {
		Order entity = new Order();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public String toString() {
		return "OrderOutDto [oid=" + oid + ", uid=" + uid + ", ostatus=" + ostatus + ", odate=" + odate
				+ ", oreturnDate=" + oreturnDate + ", bname=" + bname + "]";
	}
	
	
}
