package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import com.app.pojos.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(length = 30)
	private String user_id; // this is email
	
	@Column(length = 30)
	private String first_name;
	
	@Column(length = 30 )
	private String last_name;
	
	@Column(length = 30) // in fronted set max to 30
	private String email;
	
	@Column(length = 30) // in fronted set max to 30
	private String password;
	
	@Column(length = 30) // in fronted set max to 30
	private String role;		//admin, cusomer, service
	
	@Column(length = 100)
	private String company_name; // only for service provider // shop name with address 
	
	@Column(length = 12)
	private String contact_number;
	
	@Column(length = 100)
	private String address;
	
	public User() {
		System.out.println("In ctor of User");
	}

	public User(String user_id, String first_name, String last_name, String email, String password, String role,
			String company_name, String contact_number, String address) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.company_name = company_name;
		this.contact_number = contact_number;
		this.address = address;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", password=" + password + ", role=" + role + ", company_name=" + company_name
				+ ", contact_number=" + contact_number + ", address=" + address + "]";
	}
	
	
}