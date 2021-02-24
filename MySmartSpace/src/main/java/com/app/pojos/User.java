package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30 )
	private String lastName;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 30)
	private String password;
	
	@Column(length = 30) 
	@Enumerated(EnumType.STRING)
	private Role role;		
	
	@Column(length = 100, nullable = true)
	private String companyName; // only for service provider // shop name with address 
	
	@Column(length = 12)
	private String contactNumber;
	
	@Column(length = 100)
	private String address;
	
	public User() {
		System.out.println("In ctor of User");
	}

	public User(Integer userId, String firstName, String lastName, String email, String password, Role role,
			String companyName, String contactNumber, String address) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.companyName = companyName;
		this.contactNumber = contactNumber;
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", companyName=" + companyName + ", contactNumber="
				+ contactNumber + ", address=" + address + "]";
	}

}