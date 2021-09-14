package com.pos.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.staff.entity.Country;
import com.pos.staff.service.OrderItemService;

@RestController
@RequestMapping("/api/country")
@CrossOrigin("http://localhost:4200")
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
//	@PostMapping("/country")
//	public ResponseEntity<String> addOrderItem(@RequestBody Country country)
//	{
//		return countryService.addCountry(country);
//	}

}
