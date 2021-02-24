	package com.app.controller;
	

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.modules.Login;
import com.app.pojos.NewRequest;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.INewRequestService;
import com.app.service.IUserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userservice;
	
	@Autowired
	private INewRequestService reqService;

	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> users = userservice.getAllUsers();
		System.out.println(users);
		if (users.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserDetails(@PathVariable int userId){
		Optional<User> userDetails=userservice.getUserById(userId);
		if(userDetails.isPresent())
			return new ResponseEntity<>(userDetails.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody User u) {
		try {
			Optional<User> isUserAvailable=userservice.getUserByEmail(u.getEmail());
			if(isUserAvailable.isPresent()) {
				return null;
			}
			User savedUser = userservice.addUser(u);
			return new ResponseEntity<>(savedUser, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> doLoginMethod(@RequestBody Login credentials){
		System.out.println("in Login Method");
		System.out.println(credentials);
		Optional<User> u=userservice.validateUser(credentials);
		if(u.isPresent())
			return new ResponseEntity<>(u.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/*
	@PostMapping("/newrequest/post")
	public ResponseEntity<?> postNewRequest(@RequestBody NewRequest newRequest){

		System.out.println(newRequest);
		try {
			NewRequest savedRequest=reqService.addNewRequest(newRequest);
			return new ResponseEntity<>(savedRequest, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	@GetMapping("/role/{role}")
	public ResponseEntity<?> getUsersByRole(@PathVariable Role role){
		List<User> users=userservice.getUsersByRole(role);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{userId}")
	public ResponseEntity<?> removeUser(@PathVariable int userId){
		userservice.removeUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
