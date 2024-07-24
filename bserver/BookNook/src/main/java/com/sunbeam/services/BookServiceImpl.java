package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunbeam.daos.BookDao;
import com.sunbeam.entities.Book;
import com.sunbeam.utils.StorageService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao dao;
	
	@Autowired
	private StorageService storageService;

	@Override
	public Book saveBook(Book book, MultipartFile front, MultipartFile back) {
		String fileName1 = storageService.store(front);
		String fileName2 = storageService.store(back);
		book.setBfront(fileName1);
		book.setBback(fileName2);
		System.out.println("save called");
		return dao.save(book);
	}

	@Override
	public List<Book> findBookAll() {
		return dao.findAll();
	}

	@Override
	public List<Book> findByCategoryCatId(int id) {
		return dao.findByCategoryCatId(id);
	}

//	@Override
//	public Book findById(int id) {
//		Optional<Book> book = dao.findById(id);
//		System.out.println(book);
//		return book.orElse(null);
//	}

	@Override
	public Book findById(int id) {
		return dao.findBybId(id);
	}
	

	@Override
	public List<Book> findByOrderByCreatedTimestampDesc() {
		return dao.findByOrderByCreatedTimestampDesc();
	}

	@Override
	public List<Book> findBookLikeTitle(String title) {
		return dao.findByBnameContaining(title);
	}

	@Override
	public boolean existsByIdOrNot(int id) {
		return dao.existsById(id);
	}


	@Override
	public Book save(Book b) {
		return dao.save(b);
}

	@Override
	public List<Book> findTop5ByOrderByCreatedTimestampDesc() {
		return dao.findTop5ByOrderByCreatedTimestampDesc();
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}
	
	

}
