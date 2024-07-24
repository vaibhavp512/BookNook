package com.sunbeam.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Admin;
import com.sunbeam.entities.Customer;
import com.sunbeam.models.CustomerDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.AdminService;
import com.sunbeam.services.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	
	@Autowired
	private CustomerService cservice;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestParam String ademail, @RequestParam String adpassword) {
		Admin admin = null;
		try {
			admin = service.authenticate(ademail, adpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (admin == null) {
			return Response.error(admin);
		}
		return Response.success(admin);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Admin a) {

		Admin admin = null;
		try {
			admin = service.save(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(admin);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable("id") int id) {
		Admin admin = null;
		try {
			admin = service.findByadId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(admin);
	}
	
	@GetMapping("/cust")
	public ResponseEntity<?> getCustomers() {
		List<Customer> list = null;
		List<Customer> clist = new ArrayList<Customer>();
		try {
			list = cservice.findAllCustomers();
			for(Customer c: list) {
				if(c.getUrole().equals("customer"))
					clist.add(c);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		Stream<CustomerDto> result = clist.stream().map(cust -> CustomerDto.fromEntity(cust));
		if(list.isEmpty())
			return Response.error("error while fetching");
		return Response.success(result);
	}
}
