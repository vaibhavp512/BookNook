package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.PlansDetailsDao;
import com.sunbeam.entities.PlansDetails;

@Service
public class PlansDetailsServiceImpl implements PlansDetailsService {

	@Autowired
	private PlansDetailsDao dao;
	
	@Override
	public PlansDetails save(PlansDetails pd) {
		return dao.save(pd);
	}

	@Override
	public PlansDetails findByPlid(int id) {
		return dao.findByPlid(id);
	}

	@Override
	public List<PlansDetails> findAll() {
		return dao.findAll();
	}

}
