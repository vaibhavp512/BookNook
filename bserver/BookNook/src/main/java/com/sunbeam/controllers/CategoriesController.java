package com.sunbeam.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Book;
import com.sunbeam.entities.Categories;
import com.sunbeam.models.BookDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.CategoriesService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/categories")
@RestController
public class CategoriesController {
	
	@Autowired
	private CategoriesService cservice;
	
	@PostMapping
	public ResponseEntity<?> addCategory(@RequestBody Categories c){
		Categories cat = null;
		try {
			cat = cservice.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(cat);
	}

	@GetMapping
	public ResponseEntity<?> getCategory(){
		List<Categories> cat = null;
		try {
			cat = cservice.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(cat);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> deleteCategoriesById(@PathVariable("id") int id) {
		try {
			cservice.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return Response.success("success");
	}
	
}
