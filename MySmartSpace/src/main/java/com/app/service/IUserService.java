package com.app.service;
import java.util.List;
import java.util.Optional;

import com.app.modules.Login;
import com.app.pojos.*;

public interface IUserService {
	List<User> getAllUsers();
	Optional<User> getUserById(int userId);
	Optional<User> getUserByEmail(String email);
	User addUser(User newUser);
	Optional<User> validateUser(Login credentials);
	List<User> getUsersByRole(Role role);
	void removeUser(int userId);
}
