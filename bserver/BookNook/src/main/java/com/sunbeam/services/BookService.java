package com.sunbeam.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.entities.Book;

public interface BookService {
	Book save(Book b);
	List<Book> findBookAll();
	Book saveBook (Book book, MultipartFile front, MultipartFile back);
	List<Book> findByCategoryCatId(int id);
	List<Book> findByOrderByCreatedTimestampDesc();
	List<Book> findTop5ByOrderByCreatedTimestampDesc();
	Book findById(int id);
	List<Book> findBookLikeTitle(String title);
	boolean existsByIdOrNot(int id);
	void deleteById(int id);
}
