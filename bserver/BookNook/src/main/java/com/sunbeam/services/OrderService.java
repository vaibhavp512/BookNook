package com.sunbeam.services;

import java.util.List;
import java.util.Set;

import com.sunbeam.entities.Order;


public interface OrderService {

	Order findByOid(int id);
	Order saveOrder(Order o);
	List<Order> findByCustomerId(int id);
	List<Order> findAll();
	Set<Integer> findAllByUid();
	List<Order> findByDid(int id);
	List<Order> findByOrderByOdateDesc(int id);
}
