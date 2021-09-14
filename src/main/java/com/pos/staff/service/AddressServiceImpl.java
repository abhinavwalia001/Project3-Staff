package com.pos.staff.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.staff.dao.AddressDao;
import com.pos.staff.dao.CountryDao;
import com.pos.staff.dao.CustomerDao;
import com.pos.staff.dao.StateDao;
import com.pos.staff.entity.Address;
import com.pos.staff.entity.Country;
import com.pos.staff.entity.Customer;
import com.pos.staff.entity.State;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressDao addressDao;
		
	@Autowired
	private StateDao stateDao;
	
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public ResponseEntity<String> addAddress(Long stateId,Long customerId, Address address) {
		// TODO Auto-generated method stub
		State stateModel = stateDao.getById(stateId);
		address.setState(stateModel);
		
		Customer customer = customerDao.getById(customerId);
		address.setCustomer(customer);
		
		addressDao.save(address);
		return new ResponseEntity<String>("Address Details Added Successfully!",new HttpHeaders(),HttpStatus.OK);
	}

	@Override
	public List<Address> getAddressByCustomerId(Long phoneNumber) {
		// TODO Auto-generated method stub
		List<Address> addressList = new ArrayList<>();
		addressList = addressDao.getByMobileNumber(phoneNumber);
		return addressList;
	}

}
