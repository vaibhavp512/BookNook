package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AdminDao;
import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Admin;
import com.sunbeam.entities.Customer;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;
	
	@Override
	public Admin findByadId(int id) {
		System.out.println("find by id called");
		return dao.findByadId(id);
	}

	@Override
	public Admin findByademail(String email) {
		return dao.findByademail(email);
	}

	@Override
	public Admin save(Admin u) {
		return dao.save(u);
	}

	@Override
	public Admin authenticate(String email, String password) {
		Admin admin = findByademail(email);
		if (admin != null && admin.getAdpassword().equals(password))
			return admin;
		return null;
	}

}
