package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // how to make auto generated
	private Integer payment_id;
	
	private Integer order_id;

	@Column(name = "payment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "payment_date")
	private LocalDate payment_date; 
	 
	private double paymentAmount;
	
	 
	public Payment() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	public Payment(Integer payment_id, Integer order_id, LocalDate payment_date, double paymentAmount) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.payment_date = payment_date;
		this.paymentAmount = paymentAmount;
	}



	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public LocalDate getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(LocalDate payment_date) {
		this.payment_date = payment_date;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", order_id=" + order_id + ", payment_date=" + payment_date
				+ ", paymentAmount=" + paymentAmount + "]";
	}
	
	

}