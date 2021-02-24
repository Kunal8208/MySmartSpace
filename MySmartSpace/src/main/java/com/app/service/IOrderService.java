package com.app.service;
import java.util.List;
import java.util.Optional;

import com.app.pojos.Order;
import com.app.pojos.User;

public interface IOrderService {
	public Optional<Order> getOrderById(int orderId);
	public List<Order> getOrderByCustomerId(User customer);
	public List<Order> getOrderByServiceProviderId(User serviceProvider);
	public Order placeOrder(Order newOrder);
	public Order updatePaymentStatus(int orderId);
}
