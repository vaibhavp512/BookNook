package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Author;
import com.sunbeam.models.Response;
import com.sunbeam.services.AuthorService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/author")
@RestController
public class AuthorController {
	@Autowired
	private AuthorService aservice;
	
	@PostMapping
	public ResponseEntity<?> addAuthor(@RequestBody Author a) {
		Author auth = null;
		try {
			auth = aservice.save(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(auth);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAuthors(){
    List<Author> list = aservice.findAll();
		
		return Response.success(list);
	}

}
