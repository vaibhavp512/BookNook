package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Author;

public interface AuthorService {
	Author save(Author a);
	Author findByaId(int id);
	List<Author> findAll();

}
