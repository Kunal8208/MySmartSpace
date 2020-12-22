package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="NewRequestTable")
public class NewRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer request_id;

	private String user_id;
	
	@Column(length = 30)
	private String category;
	
	@Column(length = 30)
	private String dimension;
	
	private double weight;
	
	@Column(length = 30 )
	private String controller; // arduino esp32
	
	@Column(length = 30)
	private String sensor; // 
	
	@Column(length = 30)
	private String build_type;
	
	@Column(length = 30)
	private String motor_type; // stepper or geared
	
	@Column(length = 30)
	private String wiring_type;
	
	@Column(length = 30)
	private String power_supply_unit; // smps transformer
	
	@Column(length = 30)
	private String bluetooth_enabled; // if yes then type 

	private boolean internet_controlled; // yes no only
	
	@Column(length = 30)
	private String camera_equipped; // if yes then specify
	
	@Column(length = 30)
	private String physical_remote; // if yes then specify

	@Column(length = 500)
	private String working;
	
}
