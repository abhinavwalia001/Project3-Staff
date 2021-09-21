package com.pos.staff.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.staff.dto.OrderListDto;
import com.pos.staff.entity.Order;
import com.pos.staff.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add-order/{customerId}/{addressId}")
	public ResponseEntity<String> addAddress(@PathVariable("customerId") Long customerId,@PathVariable("addressId") Long addressId,@RequestBody Order order)
	{
		System.out.println(order);
		return orderService.addOrder(customerId,addressId,order);
	}
	
	@GetMapping("/get-orders")
		public List<Order> getOrder () {
			return orderService.getAllOrder();
	}	
	
	@GetMapping("/get-orders/{customer-id}")
	public ResponseEntity<OrderListDto> getOrdersOfCustomer(@PathVariable("customer-id")Long customerId){
		return orderService.getOrders(customerId);
	}
	
	@GetMapping("/get-order/{orderId}")
	public Order getOrderById(@PathVariable("orderId")Integer orderId) {
		return orderService.getOrderById(orderId);
		
	}
	@GetMapping("/order/{userId}")
	public Integer getOrderId(@PathVariable("userId") Long userId)
	{
		return orderService.getOrderId(userId);
	}
	
	@DeleteMapping("/delete-order/{orderId}")
	public String deleteOrder(@PathVariable("orderId") Integer orderId) {
		return orderService.deleteOrder(orderId);
	}
	
	
	@PutMapping("/update-order/{orderId}")
	public String updateOrder(@PathVariable("orderId") Integer orderId,@RequestBody Order order) {
		return orderService.updateOrder(orderId,order);
	
	}	

}
