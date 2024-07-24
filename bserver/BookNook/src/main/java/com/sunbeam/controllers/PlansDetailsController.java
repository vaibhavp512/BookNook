package com.sunbeam.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sunbeam.entities.PlansDetails;
import com.sunbeam.models.BookDto;
import com.sunbeam.models.PlanDetailsDto;
import com.sunbeam.models.Response;

import com.sunbeam.services.PlansDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/plansDetails")
@RestController
public class PlansDetailsController {

	@Autowired
	private PlansDetailsService pdservice;

	@PostMapping
	public ResponseEntity<?> addpd(@RequestBody PlansDetails pd) {
		PlansDetails pld = null;
		try {
			pld = pdservice.save(pd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(pld);
	}
	
	 @GetMapping
	   public ResponseEntity<?> getAllPlans(){
	       List<PlansDetails> list = pdservice.findAll();
	       Stream<PlanDetailsDto> result = list.stream().map(book -> PlanDetailsDto.fromEntity(book));
	       return Response.success(result);
	 }

}
