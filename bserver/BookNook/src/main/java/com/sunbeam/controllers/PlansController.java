package com.sunbeam.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Plans;
import com.sunbeam.entities.PlansDetails;
import com.sunbeam.models.PlansDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.PlansDetailsService;
import com.sunbeam.services.PlansService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/plans")
@RestController
public class PlansController {

	@Autowired
	private PlansDetailsService pdservice;
	@Autowired
	private PlansService pservice;

	@PostMapping
	public ResponseEntity<?> addPlan(@RequestBody PlansDto p) {
		PlansDetails pd = pdservice.findByPlid(p.getPlid());
		Plans plan = PlansDto.toEntity(p);
		plan.setPlandetails(pd);
		plan.setPstartDate(Calendar.getInstance().getTime());
		if (pd.getPname().equals("quarterly")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(plan.getPstartDate());
			cal.add(Calendar.MONTH, 3);
			plan.setPexpDate(cal.getTime());
		
		} else if (pd.getPname().equals("halfyearly")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(plan.getPstartDate());
			cal.add(Calendar.MONTH, 6);
			plan.setPexpDate(cal.getTime());
			
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(plan.getPstartDate());
			cal.add(Calendar.MONTH, 12);
			plan.setPexpDate(cal.getTime());
			
		}

		try {
			plan = pservice.save(plan);

		} catch (Exception e) {
			e.printStackTrace();
		}
		PlansDto dto = PlansDto.fromEntity(plan);
		return Response.success(dto);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getPlansbyUid(@PathVariable("id") int id) {
		PlansDto dto;
		PlansDetails pds;
		try {
			
			 Plans plan = pservice.findByUid(id);
			 dto = PlansDto.fromEntity(plan);
			 pds = pdservice.findByPlid(plan.getPlandetails().getPlid());
			 dto.setPname(pds.getPname());
			 dto.setPamount(pds.getPamount());
			 dto.setPblimit(pds.getPblimit());
			 
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return Response.success(dto);
		
	}
	
	
	
	
	
	
	
	

}
