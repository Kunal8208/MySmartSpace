package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.pojos.Order;
import com.app.pojos.User;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	IOrderDao dao;

	@Override
	public Optional<Order> getOrderById(int orderId) {
		return dao.findById(orderId);
	}

	@Override
	public List<Order> getOrderByCustomerId(User customer) {
		return dao.findByCustomerId(customer);
	}

	@Override
	public Order placeOrder(Order newOrder) {
		return dao.save(newOrder);
	}

	@Override
	public List<Order> getOrderByServiceProviderId(User serviceProvider) {
		return dao.findByServiceProviderId(serviceProvider);
	}

	@Override
	public Order updatePaymentStatus(int orderId) {
		Order order=dao.findById(orderId).get();
		order.setPaymentStatus(true);
		Order savedOrder = dao.save(order);
		return savedOrder;
	}

	

}
