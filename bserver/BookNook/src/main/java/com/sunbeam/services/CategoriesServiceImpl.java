package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.CategoriesDao;
import com.sunbeam.entities.Categories;


@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDao dao;
	
	@Override
	public Categories findBycatId(int id) {
		return dao.findBycatId(id);
	}

	@Override
	public Categories save(Categories c) {
		return dao.save(c);
	}

	@Override
	public List<Categories> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}
