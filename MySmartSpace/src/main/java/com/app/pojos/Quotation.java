package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="quotations")
public class Quotation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer quotationId;
	
	@ManyToOne
	@JoinColumn(name="requestId", nullable = false)
	private NewRequest requestId;
	
	@ManyToOne
	@JoinColumn(name="serviceProviderId", nullable = false)
	private User serviceProviderId;
			
	private double finalPrice;
	
	@Column(length = 500)
	private String response;
	
	private Integer acceptanceStatus; // 0-New, 1-Accepted, 2-Rejected
	
	public Quotation() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Quotation(Integer quotationId, NewRequest requestId, User serviceProviderId, double finalPrice,
			String response, Integer acceptanceStatus) {
		super();
		this.quotationId = quotationId;
		this.requestId = requestId;
		this.serviceProviderId = serviceProviderId;
		this.finalPrice = finalPrice;
		this.response = response;
		this.acceptanceStatus = acceptanceStatus;
	}

	public Integer getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(Integer quotationId) {
		this.quotationId = quotationId;
	}

	public NewRequest getRequestId() {
		return requestId;
	}

	public void setRequestId(NewRequest requestId) {
		this.requestId = requestId;
	}

	public User getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(User serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Integer getAcceptanceStatus() {
		return acceptanceStatus;
	}

	public void setAcceptanceStatus(Integer acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

	@Override
	public String toString() {
		return "Quotation [quotationId=" + quotationId + ", requestId=" + requestId + ", serviceProviderId="
				+ serviceProviderId + ", finalPrice=" + finalPrice + ", response=" + response + ", acceptanceStatus="
				+ acceptanceStatus + "]";
	}

}