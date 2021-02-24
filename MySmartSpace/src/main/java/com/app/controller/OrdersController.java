package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;

import com.app.pojos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.service.IOrderService;
import com.app.service.IUserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	IOrderService service;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int orderId){
		Optional<Order> orderDetails=service.getOrderById(orderId);
		if(orderDetails.isPresent())
			return new ResponseEntity<>(orderDetails.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<?> getOrderDetailsByCustomerId(@PathVariable int customerId){
		User customer=userService.getUserById(customerId).get();
		
		List<Order> orderDetails=service.getOrderByCustomerId(customer);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}
	
	@GetMapping("/serviceprovider/{serviceProviderId}")
	public ResponseEntity<?> getOrderDetailsByServiceProviderId(@PathVariable int serviceProviderId){
		User serviceProvider=userService.getUserById(serviceProviderId).get();
		
		List<Order> orderDetails=service.getOrderByServiceProviderId(serviceProvider);
		return new ResponseEntity<>(orderDetails, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestBody Order newOrder) {
		try {
			Order placedOrder = service.placeOrder(newOrder);
			return new ResponseEntity<>(placedOrder, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
