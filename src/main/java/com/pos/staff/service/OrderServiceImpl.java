package com.pos.staff.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String deleteOrder(Long orderId) {
			
		if(!orderDao.existsById(orderId)) {
			throw new ProductIdNotFoundException("id not found");
	    }
		
		return orderDao.findById(orderId)
	            .map(order -> {
	                orderDao.delete(order);
	                   return "deleted successfully!";
	              }).orElseThrow(() -> new ProductIdNotFoundException("error finding id"));
	}

	@Override
	public String updateOrder(Long orderId, Order orderUpdated){
			
		return orderDao.findById(orderId)
				.map(order -> {
					order.setDate(orderUpdated.getDate());
					order.setTotalPrice(orderUpdated.getTotalPrice());
					order.setDiscount(orderUpdated.getDiscount());
					order.setModeOfPayment(orderUpdated.getModeOfPayment());
					order.setStatus(orderUpdated.getStatus());
						
					orderDao.save(order);
					return "Order updated successfully!";
		}).orElseThrow(()-> new ProductIdNotFoundException("error updating"));	
	}

	@Override
	public ResponseEntity<String> addOrder(Order order) {
		
		orderDao.save(order);
		System.out.println(order);
		return null;
				 
	}
			
	@Override
	public Order getOrderById(Long orderId) {
		Optional<Order> optionalOrder = orderDao.findById(orderId);
			if(optionalOrder.isPresent()) {
		    	return optionalOrder.get();
		    }else {
		    	throw new ProductIdNotFoundException("id not found");
		    }	
	}

	@Override
	public List<Order> getAllOrder() {
			
		return orderDao.findAll();
			
	}
}


