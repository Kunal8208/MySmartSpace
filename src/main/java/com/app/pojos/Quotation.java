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
	private Integer quotation_id;
	
	private Integer request_id;
	
	private String service_provider_id;
			
	private double final_price;
	
	@Column(length = 500)
	private String response;
	
	
	private boolean acceptance_status; // accept or rejected. Will be edited by USER
	// trigger when status changed to rejected previous quotation should be delted.
	
	public Quotation() {
		System.out.println("in ctor of "+getClass().getName());
	}
	
	
}