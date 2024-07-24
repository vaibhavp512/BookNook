package com.sunbeam.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Author;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Categories;
import com.sunbeam.entities.Publisher;
import com.sunbeam.models.BookDto;
import com.sunbeam.models.BookInDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.AuthorService;
import com.sunbeam.services.BookService;
import com.sunbeam.services.CategoriesService;
import com.sunbeam.services.PublisherService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/book")
@RestController
public class BookController {
	
	@Autowired
	private AuthorService aservice;
	
	@Autowired
	private BookService bservice;
	
	@Autowired
	private PublisherService pservice;
	
	@Autowired
	private CategoriesService cservice;
	
//	@PostMapping
//	public ResponseEntity<?> addBook(@RequestBody BookDto b) {
//		Author auth = aservice.findByaId(b.getAuthID());
//		Publisher pub = pservice.findBypubId(b.getPubID());
//		Categories cat = cservice.findBycatId(b.getCatID());
//		Book book = BookDto.toEntity(b);
//		book.setAuthor(auth);
//		book.setPublisher(pub);
//		book.setCategory(cat);
//		try {
//			book = bservice.save(book);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		BookDto dto = BookDto.fromEntity(book);
//		return Response.success(dto);
//	}
	
	@PostMapping
	public ResponseEntity<?> addBook(BookInDto b) {
		Author auth = aservice.findByaId(b.getAuthID());
		Publisher pub = pservice.findBypubId(b.getPubID());
		Categories cat = cservice.findBycatId(b.getCatID());
		Book book = BookInDto.toEntity(b);
		book.setAuthor(auth);
		book.setPublisher(pub);
		book.setCategory(cat);
		book.setCreatedTimestamp(Calendar.getInstance().getTime());
		try {
			book = bservice.saveBook(book, b.getBfront(), b.getBback());
		} catch (Exception e) {
			throw new RuntimeException();
		}
		BookDto dto = BookDto.fromEntity(book);
		return Response.success(dto);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getBooksByCategory(@PathVariable("id") int id){
		List<Book> list = bservice.findByCategoryCatId(id);
		Stream<BookDto> result = list.stream().map(book -> BookDto.fromEntity(book));
		if(list.isEmpty())
			return Response.error(id);
		return Response.success(result);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBooksCategory(){
		List<Book> list = bservice.findBookAll();
		Stream<BookDto> result = list.stream().map(book -> BookDto.fromEntity(book));
		return Response.success(result);
	}
	
	@GetMapping("/latest")
	public ResponseEntity<?> getAllBooksDescTime(){
		List<Book> list = bservice.findByOrderByCreatedTimestampDesc();
		//List<Book> list = bservice.findTop5ByOrderByCreatedTimestampDesc();
		Stream<BookDto> result = list.stream().map(book -> BookDto.fromEntity(book));
		return Response.success(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBooksById(@PathVariable("id") int id){
		BookDto dto;
		try {
			Book book = bservice.findById(id);
			dto = BookDto.fromEntity(book);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return Response.success(dto);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> findBookLikeTitle(@RequestParam(name="q", required=false) String query) {
		if(query == null)
			query = "";
		List<Book> list = bservice.findBookLikeTitle(query);
		Stream<BookDto> result = list.stream().map(book -> BookDto.fromEntity(book));
		if(list.isEmpty())
			return Response.error(query);
		return Response.success(result);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> deleteBooksById(@PathVariable("id") int id) {
		try {
			bservice.deleteById(id);

		} catch (Exception e) {
			throw new RuntimeException();
		}
		return Response.success("success");
	}

}
