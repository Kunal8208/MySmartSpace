package com.app.pojos;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer product_id;
	
	private String service_provider_id;
	
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
	private String bluetooth_enabled; // if yes then type 
	
	private boolean internet_controlled; // yes no only
	
	@Column(length = 30)
	private String physical_remote; // if yes then specify
	
	@Column(length = 30)
	private String camera_equipped; // if yes then specify
	
	@Column(length = 30)
	private String motor_type; // stepper or geared
	
	@Column(length = 30)
	private String power_supply_unit; // smps transformer
	
	@Column(length = 30)
	private String wiring_type;
	
	@Column(length = 30)
	private String build_type;
	
	private double rating;
	
	@Column(length = 100)
	private String image_url;
	
	private double final_price;

	@Column(length = 500)
	private String description;
	
	private Integer quantity_sold;

	public Product() {
		System.out.println("in ctor of "+getClass().getName());
	}


	public Product(Integer product_id, String service_provider_id, String category, String dimension, double weight,
			String controller, String sensor, String bluetooth_enabled, boolean internet_controlled,
			String physical_remote, String camera_equipped, String motor_type, String power_supply_unit,
			String wiring_type, String build_type, double rating, String image_url, double final_price,
			String description, Integer quantity_sold) {
		super();
		this.product_id = product_id;
		this.service_provider_id = service_provider_id;
		this.category = category;
		this.dimension = dimension;
		this.weight = weight;
		this.controller = controller;
		this.sensor = sensor;
		this.bluetooth_enabled = bluetooth_enabled;
		this.internet_controlled = internet_controlled;
		this.physical_remote = physical_remote;
		this.camera_equipped = camera_equipped;
		this.motor_type = motor_type;
		this.power_supply_unit = power_supply_unit;
		this.wiring_type = wiring_type;
		this.build_type = build_type;
		this.rating = rating;
		this.image_url = image_url;
		this.final_price=final_price;
		this.description = description;
		this.quantity_sold = quantity_sold;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String getController() {
		return controller;
	}


	public void setController(String controller) {
		this.controller = controller;
	}


	public String getSensor() {
		return sensor;
	}


	public void setSensor(String sensor) {
		this.sensor = sensor;
	}


	public String getBluetooth_enabled() {
		return bluetooth_enabled;
	}


	public void setBluetooth_enabled(String bluetooth_enabled) {
		this.bluetooth_enabled = bluetooth_enabled;
	}


	public boolean isInternet_controlled() {
		return internet_controlled;
	}


	public void setInternet_controlled(boolean internet_controlled) {
		this.internet_controlled = internet_controlled;
	}


	public String getPhysical_remote() {
		return physical_remote;
	}


	public void setPhysical_remote(String physical_remote) {
		this.physical_remote = physical_remote;
	}


	public String getCamera_equipped() {
		return camera_equipped;
	}


	public void setCamera_equipped(String camera_equipped) {
		this.camera_equipped = camera_equipped;
	}


	public String getMotor_type() {
		return motor_type;
	}


	public void setMotor_type(String motor_type) {
		this.motor_type = motor_type;
	}


	public String getPower_supply_unit() {
		return power_supply_unit;
	}


	public void setPower_supply_unit(String power_supply_unit) {
		this.power_supply_unit = power_supply_unit;
	}


	public String getWiring_type() {
		return wiring_type;
	}


	public void setWiring_type(String wiring_type) {
		this.wiring_type = wiring_type;
	}


	public String getBuild_type() {
		return build_type;
	}


	public void setBuild_type(String build_type) {
		this.build_type = build_type;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getImage_url() {
		return image_url;
	}


	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



	public double getFinal_price() {
		return final_price;
	}


	public void setFinal_price(double final_price) {
		this.final_price = final_price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getQuantity_sold() {
		return quantity_sold;
	}


	public void setQuantity_sold(Integer quantity_sold) {
		this.quantity_sold = quantity_sold;
	}


	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", service_provider_id=" + service_provider_id + ", category="
				+ category + ", dimension=" + dimension + ", weight=" + weight + ", controller=" + controller
				+ ", sensor=" + sensor + ", bluetooth_enabled=" + bluetooth_enabled + ", internet_controlled="
				+ internet_controlled + ", physical_remote=" + physical_remote + ", camera_equipped=" + camera_equipped
				+ ", motor_type=" + motor_type + ", power_supply_unit=" + power_supply_unit + ", wiring_type="
				+ wiring_type + ", build_type=" + build_type + ", rating=" + rating + ", image_url=" + image_url
				+ ", final_price=" + final_price + ", description=" + description + ", quantity_sold=" + quantity_sold
				+ "]";
	}



}