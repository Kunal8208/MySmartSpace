package com.app.controller;

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
import com.app.pojos.User;
import com.app.service.INewRequestService;
import com.app.service.IUserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/newrequest")
public class NewRequestController {
	
	@Autowired
	INewRequestService reqService;
	
	@Autowired
	IUserService userService;
	
	@PostMapping
	public ResponseEntity<?> addNewRequest(@RequestBody NewRequest newRequest) {
		try {
			System.out.println("In New Request contoler:"+newRequest);
			NewRequest addedRequest = reqService.addNewRequest(newRequest);
			return new ResponseEntity<>(addedRequest, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllRequests() {

		List<NewRequest> requests = reqService.getAllRequests();
		if (requests.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(requests, HttpStatus.OK);
	}
	
	@GetMapping("/request/{requestId}")
	public ResponseEntity<?> getRequestByRequestId(@PathVariable int requestId) {

		Optional<NewRequest> request = reqService.getRequestById(requestId);
		if(request.isPresent()) {
			return new ResponseEntity<>(request, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getAllRequestsByUserId(@PathVariable int userId) {

		Optional<User> userDetails=userService.getUserById(userId);
		User user=userDetails.get();
		List<NewRequest> requests = reqService.getRequestsByUserId(user);
		return new ResponseEntity<>(requests, HttpStatus.OK);
	}
	
	
	@GetMapping("/serviceprovider/{serviceProviderId}")
	public ResponseEntity<?> getNewRequestsOfServiceProvider(@PathVariable int serviceProviderId) {

		Optional<User> serviceProviderDetails=userService.getUserById(serviceProviderId);
		User serviceProvider=serviceProviderDetails.get();
		List<NewRequest> requests = reqService.getNewRequestsForServiceProvider(serviceProvider);
		return new ResponseEntity<>(requests, HttpStatus.OK);
	}
}
