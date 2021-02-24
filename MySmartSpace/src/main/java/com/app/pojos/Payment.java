package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // how to make auto generated
	private Integer paymentId;
	
	@OneToOne
	private Order orderId;

	@Column(name = "paymentDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "paymentDate")
	private LocalDate paymentDate; 
	 
	private double paymentAmount;
	
	 
	public Payment() {
		System.out.println("in ctor of "+getClass().getName());
	}


	public Payment(Integer paymentId, Order orderId, LocalDate paymentDate, double paymentAmount) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
	}


	public Integer getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}


	public Order getOrderId() {
		return orderId;
	}


	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	public double getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", paymentDate=" + paymentDate
				+ ", paymentAmount=" + paymentAmount + "]";
	}

}