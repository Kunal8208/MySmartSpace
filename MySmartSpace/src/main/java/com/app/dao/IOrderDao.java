package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Order;
import com.app.pojos.User;

public interface IOrderDao extends JpaRepository<Order, Integer> {
	public List<Order> findByCustomerId(User customer);
	public List<Order> findByServiceProviderId(User serviceProvider);
}
