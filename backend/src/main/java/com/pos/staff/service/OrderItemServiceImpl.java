package com.pos.staff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pos.staff.dao.OrderDao;
import com.pos.staff.dao.OrderItemDao;
import com.pos.staff.dao.ProductDao;
import com.pos.staff.entity.Order;
import com.pos.staff.entity.OrderItem;
import com.pos.staff.entity.Product;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	@Override
	public ResponseEntity<String> addItems(Integer orderId, Integer productId, OrderItem orderItem) {
		// TODO Auto-generated method stub
		ResponseEntity<String> response=null;
		if(!orderDao.existsById(orderId))
		{
			response=new ResponseEntity<String>("Order Id Not Found!",new HttpHeaders(),HttpStatus.OK);
		}
		if(!productDao.existsById(productId))
		{
			response=new ResponseEntity<String>("Product Id Not Found!",new HttpHeaders(),HttpStatus.OK);
		}
		Order order=orderDao.findById(orderId).get();
		orderItem.setOrder(order);
		Product product=productDao.findById(productId).get();
		orderItem.setProduct(product);
		orderItem.setPrice(product.getMrp()*orderItem.getQuantity());
		orderItemDao.save(orderItem);
		response=new ResponseEntity<String>("Items added successfully!",new HttpHeaders(),HttpStatus.OK);
		return response;
	}
	
	

}
