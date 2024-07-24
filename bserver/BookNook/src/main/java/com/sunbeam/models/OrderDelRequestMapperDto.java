package com.sunbeam.models;

import java.util.List;

public class OrderDelRequestMapperDto {
	List<Integer> orderIds;
	String ostatus;
	int did;
	
	public OrderDelRequestMapperDto(List<Integer> orderIds, String ostatus, int did) {
		this.orderIds = orderIds;
		this.ostatus = ostatus;
		this.did = did;
	}

	public OrderDelRequestMapperDto() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Integer> orderIds) {
		this.orderIds = orderIds;
	}

	public String getOstatus() {
		return ostatus;
	}

	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	@Override
	public String toString() {
		return "OrderDelRequestMapperDto [orderIds=" + orderIds + ", ostatus=" + ostatus + ", did=" + did + "]";
	}

	
	
	
}
