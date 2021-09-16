package com.pos.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.staff.entity.Country;
import com.pos.staff.entity.OrderItem;
import com.pos.staff.service.OrderItemService;

@RestController
@RequestMapping("/api/order-item")
@CrossOrigin("http://localhost:4200")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@PostMapping("/order/{orderId}/product/{productId}/add-item")
	public ResponseEntity<String> addItems(@PathVariable("orderId") Integer orderId,@PathVariable("productId") Integer productId,@RequestBody OrderItem orderItem)
	{
		return orderItemService.addItems(orderId,productId,orderItem);
	}

}
