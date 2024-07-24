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

import com.sunbeam.entities.Publisher;
import com.sunbeam.models.Response;
import com.sunbeam.services.PublisherService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/publisher")
@RestController
public class PublisherController {
	@Autowired
	private PublisherService pservice;
	
	@PostMapping
	public ResponseEntity<?> addPublisher(@RequestBody Publisher p) {
		Publisher pub = null;
		try {
			pub = pservice.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(pub);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllpublisher(){
    List<Publisher> list = pservice.findAll();
		
		return Response.success(list);
	}

}
