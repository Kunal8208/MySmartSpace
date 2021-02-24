package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.*;

public interface IUserDao extends JpaRepository<User, Integer> {
	public Optional<User> findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmail(String email);
	public List<User> findByRole(Role role);
}
