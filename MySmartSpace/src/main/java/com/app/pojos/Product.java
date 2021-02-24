package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name="serviceProviderId", nullable = false)
	private User serviceProviderId;
	
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private ProductCategory category;
	
	@Column(length = 30)
	private String dimension;
	
	private double weight;
	
	@Column(length = 30 )
	private String controller; // arduino esp32
	
	@Column(length = 30)
	private String sensor; // 
	
	@Column(length = 30, nullable = true)
	private String bluetoothEnabled; // if yes then type 
	
	private boolean internetControlled; // yes no only
	
	@Column(length = 30, nullable = true)
	private String physicalRemote; // if yes then specify
	
	@Column(length = 30, nullable = true)
	private String cameraEquipped; // if yes then specify
	
	@Column(length = 30)
	private String motorType; // stepper or geared
	
	@Column(length = 30)
	private String powerSupplyUnit; // smps transformer
	
	@Column(length = 30)
	private String wiringType;
	
	@Column(length = 30)
	private String buildType;
	
	private double rating;
	
	@Column(length = 100)
	private String imageUrl;
	
	private double finalPrice;

	@Column(length = 500)
	private String description;
	
	@Column
	private Integer quantitySold=0;

	public Product() {
		System.out.println("in ctor of "+getClass().getName());
	}

	public Product(Integer productId, User serviceProviderId, ProductCategory category, String dimension, double weight,
			String controller, String sensor, String bluetoothEnabled, boolean internetControlled,
			String physicalRemote, String cameraEquipped, String motorType, String powerSupplyUnit, String wiringType,
			String buildType, double rating, String imageUrl, double finalPrice, String description,
			Integer quantitySold) {
		super();
		this.productId = productId;
		this.serviceProviderId = serviceProviderId;
		this.category = category;
		this.dimension = dimension;
		this.weight = weight;
		this.controller = controller;
		this.sensor = sensor;
		this.bluetoothEnabled = bluetoothEnabled;
		this.internetControlled = internetControlled;
		this.physicalRemote = physicalRemote;
		this.cameraEquipped = cameraEquipped;
		this.motorType = motorType;
		this.powerSupplyUnit = powerSupplyUnit;
		this.wiringType = wiringType;
		this.buildType = buildType;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.finalPrice = finalPrice;
		this.description = description;
		this.quantitySold = quantitySold;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public User getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(User serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
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

	public String getBluetoothEnabled() {
		return bluetoothEnabled;
	}

	public void setBluetoothEnabled(String bluetoothEnabled) {
		this.bluetoothEnabled = bluetoothEnabled;
	}

	public boolean isInternetControlled() {
		return internetControlled;
	}

	public void setInternetControlled(boolean internetControlled) {
		this.internetControlled = internetControlled;
	}

	public String getPhysicalRemote() {
		return physicalRemote;
	}

	public void setPhysicalRemote(String physicalRemote) {
		this.physicalRemote = physicalRemote;
	}

	public String getCameraEquipped() {
		return cameraEquipped;
	}

	public void setCameraEquipped(String cameraEquipped) {
		this.cameraEquipped = cameraEquipped;
	}

	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	public String getPowerSupplyUnit() {
		return powerSupplyUnit;
	}

	public void setPowerSupplyUnit(String powerSupplyUnit) {
		this.powerSupplyUnit = powerSupplyUnit;
	}

	public String getWiringType() {
		return wiringType;
	}

	public void setWiringType(String wiringType) {
		this.wiringType = wiringType;
	}

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", serviceProviderId=" + serviceProviderId + ", category=" + category
				+ ", dimension=" + dimension + ", weight=" + weight + ", controller=" + controller + ", sensor="
				+ sensor + ", bluetoothEnabled=" + bluetoothEnabled + ", internetControlled=" + internetControlled
				+ ", physicalRemote=" + physicalRemote + ", cameraEquipped=" + cameraEquipped + ", motorType="
				+ motorType + ", powerSupplyUnit=" + powerSupplyUnit + ", wiringType=" + wiringType + ", buildType="
				+ buildType + ", rating=" + rating + ", imageUrl=" + imageUrl + ", finalPrice=" + finalPrice
				+ ", description=" + description + ", quantitySold=" + quantitySold + "]";
	}

}