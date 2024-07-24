package com.sunbeam.controllers;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Address;
import com.sunbeam.entities.Customer;
import com.sunbeam.models.AddressDto;
import com.sunbeam.models.BookDto;
import com.sunbeam.models.CustomerDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.AddressService;
import com.sunbeam.services.CustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private AddressService aservice;


	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Customer c) {
		Customer cust = null;
		try {
			cust = service.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(cust);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> edit(@RequestBody Customer c) {
		System.out.println(c.getuId());
		Customer fromdb = service.findByuId(c.getuId());
		System.out.println(fromdb);
		Customer cust = null;
		c.setUemail(fromdb.getUemail());
		c.setUpassword(fromdb.getUpassword());
		try {
			cust = service.save(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.success(cust);
	}
	
	
	@PutMapping("/updatePass")
	public ResponseEntity<?> updatePassword(@RequestParam String oldPass, @RequestParam String newPass, @RequestParam int id) {

		Customer cust = service.findByuId(id);
		System.out.println(cust);
		System.out.println(cust.getUpassword());
		if(cust.getUpassword().equals(oldPass)) {
			System.out.println("before setting new pass in if" + newPass);
			cust.setUpassword(newPass);
			System.out.println("in if loop " + cust);
			service.save(cust);
			CustomerDto dto = CustomerDto.fromEntity(cust);
			return Response.success(dto);
		}
		else {
			return Response.error("error");
		}
	}
	

	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") int id) {
		Customer cust = null;
		try {
			cust = service.findByuId(id);
			System.out.println(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cust);
		CustomerDto dto = CustomerDto.fromEntity(cust);
		return Response.success(dto);
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticate(@RequestParam String uemail, @RequestParam String upassword) {
		System.out.println("start");
		System.out.println(uemail);
		System.out.println(upassword);
		Customer cust = null;
		try {
			cust = service.authenticate(uemail, upassword);
			System.out.println("in try block" + cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CustomerDto dto = CustomerDto.fromEntity(cust);
		System.out.println(dto);
		if (cust == null) {
			return Response.error(dto);
		}
		return Response.success(dto);
	}
	
	@PostMapping("/address")
	public ResponseEntity<?> addAddress(@RequestBody AddressDto a) {
		System.out.println("staert");
		System.out.println("got object" + a);
		Address addr = AddressDto.toEntity(a);
		Customer c = service.findByuId(a.getUid());
		System.out.println(c);
		addr.setCustomer(c);
		System.out.println(addr);
		if(c.getAddress()!=null) {
			addr.setAid(c.getAddress().getAid());
		}
		try {
			addr = aservice.save(addr);
			System.out.println("value of adr is" + addr); 
			System.out.println("before adding adrs" + c);
			c.setAddress(addr);
			System.out.println("after adding adrs" + c);
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		AddressDto dto = AddressDto.fromEntity(addr);
		return Response.success(dto);
	}
	

	@PutMapping("/addrEdit")
	public ResponseEntity<?> editAddress(@RequestBody AddressDto a) {
		Address addr = AddressDto.toEntity(a);
		Customer c = service.findByuId(a.getUid());
		addr.setCustomer(c);
		addr.setAid(c.getAddress().getAid());
		try {
			addr = aservice.save(addr);
			c.setAddress(addr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		AddressDto dto = AddressDto.fromEntity(addr);
		return Response.success(dto);
	}
	
	//here user id is passed from client 
	@GetMapping("/getAddress/{id}")
	public ResponseEntity<?> getAddress(@PathVariable("id") int id) {
		Address addr = null;
		Customer cust = null;
		try {
			cust = service.findByuId(id);
			addr = cust.getAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		AddressDto dto = AddressDto.fromEntity(addr);
		return Response.success(dto);
	}
}
