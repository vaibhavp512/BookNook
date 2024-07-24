package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.AuthorDao;
import com.sunbeam.entities.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorDao dao;

	@Override
	public Author save(Author a) {
		return dao.save(a);
	}

	@Override
	public Author findByaId(int id) {
		return dao.findByaId(id);
	}
	
	@Override
	public List<Author> findAll() {
		return dao.findAll();
		
	}


}
