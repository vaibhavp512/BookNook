package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerDao dao;

	@Override
	public Customer save(Customer c) {
		return dao.save(c);
	}


	@Override
	public Customer authenticate(String email, String password) {
		System.out.println(email + " in service");
		System.out.println(password + " in service");
		Customer Customer = findByuemail(email);
		if (Customer != null && Customer.getUpassword().equals(password)) {
			System.out.println(Customer.getUpassword().equals(password));
			System.out.println("called authenticate");
			return Customer;
		}
		return null;
	}

	@Override
	public Customer findByuemail(String email) {
		return dao.findByUemail(email);
	}

	@Override
	public Customer findByuId(int id) {
		return dao.findByuId(id);
	}


	@Override
	public List<Customer> findAllCustomers() {
		return dao.findAll();
	}
}
