package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Customer;

public interface CustomerService {
	
	Customer findByuId(int id);
	Customer save(Customer u);
//	Customer findById(int id);
//	Customer update(int id,Customer u);
	Customer authenticate(String email,String password);
	Customer findByuemail(String email);
	List<Customer> findAllCustomers();

}
