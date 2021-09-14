package com.pos.staff.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pos.staff.entity.Address;
import com.pos.staff.entity.Order;
import com.pos.staff.entity.Product;
import com.pos.staff.exception.ProductIdNotFoundException;
import com.pos.staff.exception.ProductNameNotFoundException;
import com.pos.staff.service.OrderService;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:4200")


public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add-order")
	public ResponseEntity<String> addAddress(@RequestBody Order order)
	{
		System.out.println(order);
		return orderService.addOrder(order);
	}
	
	@GetMapping("/orders")
		public List<Order> getOrder () {
			return orderService.getAllOrder();
	}	
	
	@GetMapping("/get-order/{orderId}")
	@ResponseBody
	public Order getOneOrder(@PathVariable("orderId")Long orderId) {
		return orderService.getOrderById(orderId);
		
	}
	
	
	@DeleteMapping("/delete-order/{orderId}")
	public String deleteOrder(@PathVariable("orderId") Long orderId) {
		return orderService.deleteOrder(orderId);
	}
	
	
	@PutMapping("/update-order/{orderId}")
	public String updateOrder(@PathVariable("orderId") Long orderId,@RequestBody Order order) {
		return orderService.updateOrder(orderId,order);
	
	}	

}
