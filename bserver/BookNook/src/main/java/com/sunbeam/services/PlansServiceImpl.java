package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.PlansDao;
import com.sunbeam.entities.Plans;
@Service
public class PlansServiceImpl implements PlansService {
	
	@Autowired
	private PlansDao dao;
	
	@Override
	public Plans save(Plans p) {
		
		return dao.save(p);
	}

	@Override
	public Plans findByUid(int id) {
		
		return dao.findByUid(id);
	}

}
