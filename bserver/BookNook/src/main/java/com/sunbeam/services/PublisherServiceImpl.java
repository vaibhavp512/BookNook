package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.PublisherDao;
import com.sunbeam.entities.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	private PublisherDao dao;

	@Override
	public Publisher findBypubId(int id) {
		return dao.findBypubId(id);
	}

	@Override
	public Publisher save(Publisher p) {
		return dao.save(p);
	}
	
	@Override
	public List<Publisher> findAll() {
		
		return dao.findAll();
	}


}
