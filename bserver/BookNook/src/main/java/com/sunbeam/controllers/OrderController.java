package com.sunbeam.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
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

import com.sunbeam.entities.Author;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.Order;
import com.sunbeam.models.BookDto;
import com.sunbeam.models.OrderDto;
import com.sunbeam.models.OrderOutDto;
import com.sunbeam.models.OrderCustRequestMapperDto;
import com.sunbeam.models.Response;
import com.sunbeam.services.BookService;
import com.sunbeam.services.CustomerService;
import com.sunbeam.services.OrderService;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/order")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService oservice;
	
	@Autowired
	private BookService bservice;
	
	@Autowired
	private CustomerService cservice;
	
	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody OrderCustRequestMapperDto rmd) throws Exception{
		System.out.println("****************************************");
		Set<Integer> clist = oservice.findAllByUid();		
		Book b = new Book();
		Order orderd = new Order();
		Order order = new Order();
		if(clist.contains(rmd.getOrders().getUid())) {
			List<Order> o = oservice.findByCustomerId(rmd.getOrders().getUid());
			for(Order or:o) {
				if(or.getOstatus().equals("dispatched")|or.getOstatus().equals("ordered")|or.getOstatus().equals("issued")) {
					System.out.println("has customer already with status dis ordered");
					return Response.other("You will be able to order again after processing current order!");
				}
			}
		}
		System.out.println("rmd value - "+rmd);
		List<Integer> list = rmd.getBookId();
		System.out.println("list if book-"+list);
		order.setUid(rmd.getOrders().getUid());
		order.setOstatus(rmd.getOrders().getOstatus());
		
		
		order.setOdate(Calendar.getInstance().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(order.getOdate());
		cal.add(Calendar.DATE, 15);
		order.setOreturnDate(cal.getTime());
		
		
		System.out.println("called after setting basic parameters " + order);
		try {
			for(Integer bookId:list ) {
				b = bservice.findById(bookId);
				System.out.println(b);
				if(b.getBavCopies()!=0) {
					order.addToCart(b);
					System.out.println(b.getBavCopies());
					b.setBavCopies(b.getBavCopies()-1);
					System.out.println(b.getBavCopies());
				}
				else {
					return Response.error("no available copies");
				}
			}
			orderd = oservice.saveOrder(order);
		} catch (Exception e) {
			e.getMessage();
			return Response.error(orderd);
		}
		
		OrderDto dto = OrderDto.fromEntity(orderd);
		System.out.println("dto called" + dto);
		System.out.println("****************************************");
		return Response.success(dto);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrdersByCustomer(@PathVariable("id") int id){
//		List<Order> orders = oservice.findByCustomerId(id);
		List<Order> orders = oservice.findByOrderByOdateDesc(id);
		if(orders.isEmpty()) {
			return Response.other("No orders!");
		}
		Stream<OrderDto> result = orders.stream().map(order -> OrderDto.fromEntity(order));
		
		return Response.success(result);
	}
	
	@PutMapping("/{id}/{status}")
	public ResponseEntity<?> editOrderStatusCust(@PathVariable("id") int id, @PathVariable("status") String status){
		//List<Order> orders = oservice.findByCustomerId(id);
		//considering that we are passing order id, if customer id needs to be sent then need to change code
		Order order = oservice.findByOid(id);
		order.setOstatus(status);
		Order o = oservice.saveOrder(order);
		if(o.getOstatus().equals("returned")) { 
			o.setOreturnDate(Calendar.getInstance().getTime());
			List<Book> list = o.getBookCart();
			for(Book b : list) {
				b.setBavCopies(b.getBavCopies() + 1);
				bservice.save(b);
			}	
		}
		System.out.println("returned order: "+order);
		OrderDto result = OrderDto.fromEntity(o);
		return Response.success(result);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> editOrderStatus(@PathVariable("id") int id, @RequestParam String status){
		//List<Order> orders = oservice.findByCustomerId(id);
		//considering that we are passing order id, if customer id needs to be sent then need to change code
		Order order = oservice.findByOid(id);
		order.setOstatus(status);
		Order o = oservice.saveOrder(order);
		if(o.getOstatus().equals("returned")) { 
			o.setOreturnDate(Calendar.getInstance().getTime());
			List<Book> list = o.getBookCart();
			for(Book b : list) {
				b.setBavCopies(b.getBavCopies() + 1);
				bservice.save(b);
			}	
		}
		System.out.println("returned order: "+order);
		OrderDto result = OrderDto.fromEntity(o);
		return Response.success(result);
	}
	
	@GetMapping("/custorder/{id}")
	public ResponseEntity<?> getOrdersForAllCustomer(@PathVariable("id") int id){
		List<Order> orders = oservice.findByCustomerId(id);
		Stream<OrderDto> result = orders.stream().map(order -> OrderDto.fromEntity(order));
		return Response.success(result);
	}

}







