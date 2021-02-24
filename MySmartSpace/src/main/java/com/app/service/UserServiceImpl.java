package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.modules.Login;
import com.app.pojos.Role;
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
	public Optional<User> getUserById(int userId) {
		return dao.findById(userId);
	}

	@Override
	public User addUser(User newUser) {
		return dao.save(newUser);
	}

	@Override
	public Optional<User> validateUser(Login cred) {
		return dao.findByEmailAndPassword(cred.getEmail(), cred.getPassword());
	}

	@Override
	public List<User> getUsersByRole(Role role) {
		return dao.findByRole(role);
	}

	@Override
	public void removeUser(int userId) {
		dao.deleteById(userId);
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return dao.findByEmail(email);
	}

}
