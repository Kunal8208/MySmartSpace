package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;

	@Override
	public List<User> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public Optional<User> getUserById(String userId) {
		return dao.findById(userId);
	}

	@Override
	public User addUser(User newUser) {
		return dao.save(newUser);
	}

}
