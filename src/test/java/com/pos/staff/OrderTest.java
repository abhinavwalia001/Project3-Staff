package com.pos.staff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pos.staff.dao.AddressDao;
import com.pos.staff.dao.CountryDao;
import com.pos.staff.dao.CustomerDao;
import com.pos.staff.dao.OrderDao;
import com.pos.staff.dao.StateDao;
import com.pos.staff.entity.Address;
import com.pos.staff.entity.Country;
import com.pos.staff.entity.Customer;
import com.pos.staff.entity.Order;
import com.pos.staff.entity.State;
import com.pos.staff.service.OrderService;

@SpringBootTest
public class OrderTest {
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private StateDao stateDao;
	
	@Test
	public void addOrder() {
		Order order=new Order();
		order.setModeOfPayment("Cash");
		order.setTracking("pending");
		orderService.addOrder(Long.valueOf("8124098373"), Long.valueOf(6), order);
	}
}
