package com.pos.staff.controller;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pos.staff.dto.OrderListDto;
import com.pos.staff.entity.Order;
import com.pos.staff.service.OrderService;
import com.pos.staff.util.pdfreport.BillPdfGenerator;
import com.pos.staff.util.pdfreport.PDFGenerator;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add-order/{customerId}/{addressId}")
	public ResponseEntity<String> addAddress(@PathVariable("customerId") Long customerId,@PathVariable("addressId") Long addressId,@RequestBody Order order)
	{
		System.out.println(order);
		return orderService.addOrder(customerId,addressId,order);
	}
	
	@GetMapping("/get-orders")
		public List<Order> getOrder () {
			return orderService.getAllOrder();
	}	
	
	@GetMapping(value = "/get-orders/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> salesReport()  {
	        List<Order> orders =  orderService.getAllOrder();
	
	        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(orders);
	
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=salesReport.pdf");
	
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
		
			
	}
		
	@GetMapping("/get-orders/{customer-id}")
	public ResponseEntity<OrderListDto> getOrdersOfCustomer(@PathVariable("customer-id") Long customerId){
		return orderService.getOrders(customerId);
	}
	
	
	@GetMapping(value = "/get-bill/pdf/{orderId}",
            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> billReport(@PathVariable("orderId") Integer orderId) {
	        Order order =  orderService.getOrderById(orderId);
	
	        ByteArrayInputStream bis = BillPdfGenerator.customerBillPDFReport(order);
	
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=Bill.pdf");
	
	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
		
			
	}
	
	@GetMapping("/get-order/{orderId}")
	public Order getOrderById(@PathVariable("orderId")Integer orderId) {
		return orderService.getOrderById(orderId);
		
	}
	
	
	@DeleteMapping("/delete-order/{orderId}")
	public String deleteOrder(@PathVariable("orderId") Integer orderId) {
		return orderService.deleteOrder(orderId);
	}
	
	
	@PutMapping("/update-order/{orderId}")
	public String updateOrder(@PathVariable("orderId") Integer orderId,@RequestBody Order order) {
		return orderService.updateOrder(orderId,order);
	
	}	

}
