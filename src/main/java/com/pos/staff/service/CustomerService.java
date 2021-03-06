package com.pos.staff.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.pos.staff.entity.Customer;

public interface CustomerService {

	public ResponseEntity<String> addCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public ResponseEntity<Customer> getCustomerById(Long customerId);
	
	public ResponseEntity<String> updateCustomer(Long phoneNo, Customer customerDetails);

}
