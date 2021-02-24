package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.app.pojos.NewRequest;
import com.app.pojos.Quotation;
import com.app.pojos.User;
import com.app.service.INewRequestService;
import com.app.service.IQuotationService;
import com.app.service.IUserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/quotations")
public class QuotationsController {
	
	@Autowired
	IQuotationService quotationService;
	
	@Autowired
	INewRequestService reqService;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/{requestId}")
	public ResponseEntity<?> getQuotationsForRequest(@PathVariable int requestId){
		Optional<NewRequest> request = reqService.getRequestById(requestId);
		List<Quotation> quotations=new ArrayList<Quotation>();
		if(request.isPresent()) {
			quotations = quotationService.getAllQuotationsByRequestId(request.get());
		}
		return new ResponseEntity<>(quotations, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> insertQuotation(@RequestBody Quotation newQuotation){
		try {
			Quotation addedQuotation = quotationService.insertQuotation(newQuotation);
			return new ResponseEntity<>(addedQuotation, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/reject/{quotationId}")
	public ResponseEntity<?> rejectQuotation(@PathVariable int quotationId){
		Quotation quotation= quotationService.rejectQuotation(quotationId);
		return new ResponseEntity<>(quotation, HttpStatus.OK);
	}
	
	@GetMapping("/accept/{quotationId}")
	public ResponseEntity<?> acceptQuotation(@PathVariable int quotationId){
		Quotation quotation=quotationService.AcceptQuotation(quotationId);
		return new ResponseEntity<>(quotation, HttpStatus.OK);
	}
	
	@GetMapping("/serviceprovider/{serviceProviderId}")
	public ResponseEntity<?> getQuotationsByServiceProviderId(@PathVariable int serviceProviderId){
		User serviceProvider=userService.getUserById(serviceProviderId).get();
		List<Quotation> quotations=quotationService.getAllQuotationsByServiceProviderId(serviceProvider);
		return new ResponseEntity<>(quotations, HttpStatus.OK);
	}
}
