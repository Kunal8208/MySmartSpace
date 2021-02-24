package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@ManyToOne
	private User customerId; // user_id of user making order

	@ManyToOne
	private Product productId;
	
	@ManyToOne
	private User serviceProviderId;
	
	private Integer quantity;
	
	private double totalAmount;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;   //C-up - rej - new
		
	
	@Column(columnDefinition = "boolean default false")
	private Boolean paymentStatus; // yes or no
	
	
	@Column(name = "orderDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "orderDate")
	private LocalDate orderDate; 	
	 
	@Column( length= 500)
	private String note;
	
	public Order() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Order(Integer orderId, User customerId, Product productId, User serviceProviderId, Integer quantity,
			double totalAmount, OrderStatus orderStatus, Boolean paymentStatus, LocalDate orderDate, String note) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.serviceProviderId = serviceProviderId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.orderDate = orderDate;
		this.note = note;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public User getCustomerId() {
		return customerId;
	}

	public void setCustomerId(User customerId) {
		this.customerId = customerId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public User getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(User serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId
				+ ", serviceProviderId=" + serviceProviderId + ", quantity=" + quantity + ", totalAmount=" + totalAmount
				+ ", orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + ", orderDate=" + orderDate
				+ ", note=" + note + "]";
	}

}