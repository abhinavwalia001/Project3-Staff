package com.pos.staff.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pos.staff.entity.Address;

public interface AddressDao extends JpaRepository<Address, Long>{

	@Query("SELECT a FROM Address a WHERE a.customer.phoneNumber=:phoneNumber")
	List<Address> getByMobileNumber(Long phoneNumber);

}
