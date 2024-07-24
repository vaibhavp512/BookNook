package com.sunbeam.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderCustRequestMapperDto {

	List<Integer> bookId;
	OrderDto orders;
	
	public OrderCustRequestMapperDto(List<Integer> bookId, OrderDto orders) {
		this.bookId = bookId;
		this.orders = orders;
	}
	public List<Integer> getBookId() {
		return bookId;
	}
	public void setBookId(List<Integer> bookId) {
		this.bookId = bookId;
	}
	public OrderDto getOrders() {
		return orders;
	}
	public void setOrders(OrderDto orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "RequestMapperDto [bookId=" + bookId + ", orders=" + orders + "]";
	}
	
	
}
