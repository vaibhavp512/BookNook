package com.sunbeam.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

import com.sunbeam.entities.Customer;
import com.sunbeam.entities.Order;
import com.sunbeam.models.OrderDelRequestMapperDto;
import com.sunbeam.models.OrderDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.CustomerService;
import com.sunbeam.services.OrderService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/delivery")
@RestController
public class DeliveryBoyController {
	
	@Autowired
	private OrderService oservice;
	
	@Autowired
	private CustomerService cservice;
	
	@GetMapping("/getorder")
	public ResponseEntity<?> getOrder(){
//		List<Order> orders = oservice.findByCustomerId(id);
		List<Order> orders = oservice.findAll();
		List<Order> sortedorder = new ArrayList<Order>();
		for(Order or:orders) { 
			if(or.getOstatus().equals("ordered")) {
			   sortedorder.add(or);
			}
		}
		if(orders.isEmpty()) {
			return Response.other("No orders!");
		}
		Stream<OrderDto> result = sortedorder.stream().map(order -> OrderDto.fromEntity(order));
		return Response.success(result);	
	}
	
	@PostMapping()
	public ResponseEntity<?> acceptOrderForDelivery(@RequestBody OrderDelRequestMapperDto rmd){
			Order result=null;
			for(Integer num:rmd.getOrderIds()) {
				Order o = oservice.findByOid(num);
				o.setOstatus(rmd.getOstatus());
				o.setDid(rmd.getDid());
				try {
				result = oservice.saveOrder(o);
				}
				catch(Exception e) {
					return Response.error(e);
				}
			}
			return Response.success(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderForDeliveryMan(@PathVariable("id") int id){
		List<Order> list = oservice.findByDid(id);
		List<Customer> clist = new ArrayList<Customer>();
		System.out.println(list);
		
		for(Order o:list) {
			clist.add(cservice.findByuId(o.getUid()));
		}
		System.out.println(clist);
		Stream<OrderDto> result = list.stream().map(order -> OrderDto.fromEntity(order));
		return Response.success(result);
	}
	
	@GetMapping("/mydeliveries/{id}")
	public ResponseEntity<?> getOrderForDeliveryManAssigned(@PathVariable("id") int id){
		List<Order> list = oservice.findByDid(id);
		List<Order> slist = new ArrayList<Order>();
//		List<Customer> clist = new ArrayList<Customer>();
//		System.out.println(list);
//		
//		for(Order o:list) {
//			clist.add(cservice.findByuId(o.getUid()));
//		}
//		System.out.println(clist);
		for(Order o:list) {
			if(o.getOstatus().equals("dispatched"))
				slist.add(o);
		}
		Stream<OrderDto> result = slist.stream().map(order -> OrderDto.fromEntity(order));
		return Response.success(result);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> orderDelivered(@PathVariable("id") int id){
		Order o = oservice.findByOid(id);
		o.setOstatus("issued");
		try {
			o = oservice.saveOrder(o);
		} catch (Exception e) {
			return Response.error(e);
		}
		return Response.success(o);
	}
}
