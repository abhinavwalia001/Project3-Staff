package com.pos.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.staff.entity.Customer;
import com.pos.staff.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add-customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
	{
		customer.setPassword(String.valueOf(customer.getPhoneNumber()));
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomerList() 
	{
		List<Customer> countryList = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(countryList,new HttpHeaders(),HttpStatus.OK);
	}

	@GetMapping("/get-customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId")Long phoneNumber)
	{
		return customerService.getCustomerById(phoneNumber);
	}
	
	@PutMapping("/update-customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
		return customerService.updateCustomer(customer.getPhoneNumber(),customer);
	}
}
