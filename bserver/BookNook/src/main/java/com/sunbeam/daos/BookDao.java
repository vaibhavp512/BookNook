package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer>{
	List<Book> findByCategoryCatId(int id);
	List<Book> findByOrderByCreatedTimestampDesc();
	List<Book> findByBnameContaining(String title);
	List<Book> findTop5ByOrderByCreatedTimestampDesc();
	Book findBybId(int id);
}
