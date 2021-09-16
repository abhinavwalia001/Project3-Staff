package com.pos.staff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.staff.dao.AddressDao;
import com.pos.staff.dao.CustomerDao;
import com.pos.staff.dao.OrderDao;
import com.pos.staff.dao.ProductDao;
import com.pos.staff.entity.Address;
import com.pos.staff.entity.Customer;
import com.pos.staff.entity.Order;
import com.pos.staff.entity.Product;
import com.pos.staff.exception.ProductIdNotFoundException;

@Service
@Transactional

public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private ProductDao productDao;

	@Override
	public String deleteOrder(Integer orderId) {

		return orderDao.findById(orderId).map(order -> {
			orderDao.delete(order);
			return "deleted successfully!";
		}).orElseThrow(() -> new ProductIdNotFoundException("error finding id"));
	}

	@Override
	public String updateOrder(Integer orderId, Order orderUpdated) {

		return orderDao.findById(orderId).map(order -> {
			order.setTotalPrice(orderUpdated.getTotalPrice());
			order.setDiscount(orderUpdated.getDiscount());
			order.setModeOfPayment(orderUpdated.getModeOfPayment());
			order.setStatus(orderUpdated.getStatus());
			order.setTracking(orderUpdated.getTracking());
			orderDao.save(order);
			return "Order updated successfully!";
		}).orElseThrow(() -> new ProductIdNotFoundException("error updating"));
	}

	@Override
	public ResponseEntity<String> addOrder(Long customerId, Long addressId, Order order) {
		if (!customerDao.existsById(customerId)) {
			return new ResponseEntity<String>("No Customer Found!", new HttpHeaders(), HttpStatus.OK);
		}
		if (!addressDao.existsById(addressId)) {
			return new ResponseEntity<String>("No Address Found!", new HttpHeaders(), HttpStatus.OK);
		}
		Customer customer = customerDao.findById(customerId).get();
		order.setCustomer(customer);
		Address address = addressDao.findById(addressId).get();
		order.setAddress(address);
		order.setStatus("Pending");
		order.setTotalPrice(0.0);
		orderDao.save(order);
		Long count=orderDao.getCount(customerId);
		System.out.println(count);
		if(count>5)
		{
			order.setDiscount(5.5f);
		}
		else
		{
			order.setDiscount(0.0f);
		}
		return new ResponseEntity<String>("Order Details Added Successfully!", new HttpHeaders(), HttpStatus.OK);

	}
	public String updateTotalPrice(Double price,Integer orderId)
	{
		return orderDao.findById(orderId)
				.map(order->{
					order.setTotalPrice(price);
					orderDao.save(order);
					return "Price is updated";
				}).orElse("order id not found!");
	}
	@Override
	public Order getOrderById(Integer orderId) {
		Optional<Order> optionalOrder = orderDao.findById(orderId);
		if (optionalOrder.isPresent()) {
			return optionalOrder.get();
		} else {
			throw new ProductIdNotFoundException("id not found");
		}
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.findAll();

	}

	
}
