package com.sunbeam.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.OrderDao;
import com.sunbeam.entities.Order;
import com.sunbeam.entities.Publisher;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;

	@Override
	public Order findByOid(int id) {
	
		return dao.findByOid(id);
	}

	@Override
	public Order saveOrder(Order o) {
		return dao.save(o);
	}

	@Override
	public List<Order> findByCustomerId(int id) {
		return dao.findByUid(id);
	}

	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}

	@Override
	public Set<Integer> findAllByUid() {
		return dao.findAllByUid();
	}

	@Override
	public List<Order> findByOrderByOdateDesc(int id) {
		return dao.findByuidOrderByOdateDesc(id);
	}

	@Override
	public List<Order> findByDid(int id) {
		return dao.findByDid(id);
	}
}
