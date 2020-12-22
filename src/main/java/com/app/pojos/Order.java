package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;

	private String customer_id; // user_id of user making order

	private Integer product_id;
	
	private String service_provider_id;
	
	private Integer quantity;
	
	private double total_amount;
	
	@Column(length = 5)
	private String order_status;   //C-up - rej - new
		
	
	// @Column(length = 15)
	private boolean payment_status; // yes or no
	
	
	 @Column(name = "order_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "order_date")
	private LocalDate order_date; 	
	 
	@Column( length= 500)
	private String note;
	
	public Order() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Order(Integer order_id, String customer_id, Integer product_id, String service_provider_id, Integer quantity,
			double total_amount, String order_status, boolean payment_status, LocalDate order_date, String note) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.service_provider_id = service_provider_id;
		this.quantity = quantity;
		this.total_amount = total_amount;
		this.order_status = order_status;
		this.payment_status = payment_status;
		this.order_date = order_date;
		this.note = note;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getService_provider_id() {
		return service_provider_id;
	}

	public void setService_provider_id(String service_provider_id) {
		this.service_provider_id = service_provider_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public boolean isPayment_status() {
		return payment_status;
	}

	public void setPayment_status(boolean payment_status) {
		this.payment_status = payment_status;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", service_provider_id=" + service_provider_id + ", quantity=" + quantity + ", total_amount="
				+ total_amount + ", order_status=" + order_status + ", payment_status=" + payment_status
				+ ", order_date=" + order_date + ", note=" + note + "]";
	}

}