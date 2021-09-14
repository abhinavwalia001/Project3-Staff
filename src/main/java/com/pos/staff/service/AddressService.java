package com.pos.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.pos.staff.entity.Address;
import com.pos.staff.entity.Country;
import com.pos.staff.entity.State;

public interface AddressService {

	public ResponseEntity<String> addAddress(Long stateId,Long customerId,Address address);

	public List<Address> getAddressByCustomerId(Long phoneNumber);

}
