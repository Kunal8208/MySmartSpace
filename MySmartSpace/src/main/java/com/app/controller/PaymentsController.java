package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.service.IPaymentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/payments")
public class PaymentsController {

	@Autowired
	private IPaymentService service;
	
	@PostMapping
	public ResponseEntity<?> insertPayment(@RequestBody Payment newPayment) {
		try {
			Payment insertedPayment = service.insertPayment(newPayment);
			return new ResponseEntity<>(insertedPayment, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
