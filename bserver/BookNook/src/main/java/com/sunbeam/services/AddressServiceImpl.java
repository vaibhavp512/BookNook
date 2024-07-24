package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AddressDao;
import com.sunbeam.entities.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao dao;

	@Override
	public Address save(Address a) {
		return dao.save(a);
	}
}
