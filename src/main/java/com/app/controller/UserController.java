package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService service;

	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> users = service.getAllUsers();
		System.out.println(users);
		if (users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getProductDetails(@PathVariable String userId){
		Optional<User> userDetails=service.getUserById(userId);
		if(userDetails.isPresent())
			return new ResponseEntity<>(userDetails.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User u) {
		try {
			User savedUser = service.addUser(u);
			return new ResponseEntity<>(savedUser, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
