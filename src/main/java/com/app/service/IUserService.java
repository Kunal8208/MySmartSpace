package com.app.service;
import java.util.List;
import java.util.Optional;
import com.app.pojos.*;

public interface IUserService {
	List<User> getAllUsers();
	Optional<User> getUserById(String userId);
	User addUser(User newUser);
}
