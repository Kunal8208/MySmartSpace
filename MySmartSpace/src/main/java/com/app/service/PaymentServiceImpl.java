package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderDao;
import com.app.dao.IPaymentDao;
import com.app.pojos.Order;
import com.app.pojos.Payment;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentDao paymentDao;
	
	@Autowired
	private IOrderDao orderDao;
	
	@Override
	public Payment insertPayment(Payment payment) {
		Order order = payment.getOrderId();
		order.setPaymentStatus(true);
		orderDao.save(order);
		return paymentDao.save(payment);
	}

}
