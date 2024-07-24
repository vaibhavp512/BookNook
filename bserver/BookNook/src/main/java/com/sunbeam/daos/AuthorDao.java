package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Author;

public interface AuthorDao extends JpaRepository<Author, Integer>{
	Author findByaId(int id);
}
