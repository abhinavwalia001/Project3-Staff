package com.pos.staff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.staff.dao.CustomerDao;
import com.pos.staff.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public ResponseEntity<String> addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);
		return new ResponseEntity<String>("Customer Details Added Successfully!",new HttpHeaders(),HttpStatus.OK);
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customerList = new ArrayList<>();
		customerList = customerDao.findAll();
		return customerList;
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(Long customerId) {
		// TODO Auto-generated method stub
		Customer customerDetails = customerDao.findById(customerId).get();
		return new ResponseEntity<Customer>(customerDetails,new HttpHeaders(),HttpStatus.OK);
	}

}
