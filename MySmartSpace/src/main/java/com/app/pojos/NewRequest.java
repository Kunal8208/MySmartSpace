package com.app.pojos;

import java.time.LocalDate;
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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="NewRequestTable")
public class NewRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User userId;
	
	@Column(name = "requestDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonProperty(value = "requestDate")
	private LocalDate requestDate;
	 
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
	
	@Column(length = 30)
	private String buildType;
	
	@Column(length = 30)
	private String motorType; // stepper or geared
	
	@Column(length = 30)
	private String wiringType;
	
	@Column(length = 30)
	private String powerSupplyUnit; // smps transformer
	
	@Column(length = 30, nullable = true)
	private String bluetoothEnabled; // if yes then type 

	private boolean internetControlled; // yes no only
	
	@Column(length = 30, nullable = true)
	private String cameraEquipped; // if yes then specify
	
	@Column(length = 30, nullable = true)
	private String physicalRemote; // if yes then specify

	@Column(length = 500)
	private String note;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean isValid;
	
	public NewRequest() {
		System.out.println("In ctor of NewRequest");
	}

	public NewRequest(Integer requestId, User userId, ProductCategory category, String dimension, double weight,
			String controller, String sensor, String buildType, String motorType, String wiringType,
			String powerSupplyUnit, String bluetoothEnabled, boolean internetControlled, String cameraEquipped,
			String physicalRemote, String note, Boolean isValid) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.category = category;
		this.dimension = dimension;
		this.weight = weight;
		this.controller = controller;
		this.sensor = sensor;
		this.buildType = buildType;
		this.motorType = motorType;
		this.wiringType = wiringType;
		this.powerSupplyUnit = powerSupplyUnit;
		this.bluetoothEnabled = bluetoothEnabled;
		this.internetControlled = internetControlled;
		this.cameraEquipped = cameraEquipped;
		this.physicalRemote = physicalRemote;
		this.note= note;
		this.isValid = isValid;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
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

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getMotorType() {
		return motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	public String getWiringType() {
		return wiringType;
	}

	public void setWiringType(String wiringType) {
		this.wiringType = wiringType;
	}

	public String getPowerSupplyUnit() {
		return powerSupplyUnit;
	}

	public void setPowerSupplyUnit(String powerSupplyUnit) {
		this.powerSupplyUnit = powerSupplyUnit;
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

	public String getCameraEquipped() {
		return cameraEquipped;
	}

	public void setCameraEquipped(String cameraEquipped) {
		this.cameraEquipped = cameraEquipped;
	}

	public String getPhysicalRemote() {
		return physicalRemote;
	}

	public void setPhysicalRemote(String physicalRemote) {
		this.physicalRemote = physicalRemote;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "NewRequest [requestId=" + requestId + ", userId=" + userId + ", category=" + category + ", dimension="
				+ dimension + ", weight=" + weight + ", controller=" + controller + ", sensor=" + sensor
				+ ", buildType=" + buildType + ", motorType=" + motorType + ", wiringType=" + wiringType
				+ ", powerSupplyUnit=" + powerSupplyUnit + ", bluetoothEnabled=" + bluetoothEnabled
				+ ", internetControlled=" + internetControlled + ", cameraEquipped=" + cameraEquipped
				+ ", physicalRemote=" + physicalRemote + ", working=" + note + ", isValid=" + isValid + "]";
	}

}
