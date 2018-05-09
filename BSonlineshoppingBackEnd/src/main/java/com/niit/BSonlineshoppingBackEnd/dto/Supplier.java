package com.niit.BSonlineshoppingBackEnd.dto;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "supplier_detail")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * private fields for user
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "supplier_name")
	@NotBlank(message="Please enter supplier name!")
	private String supplierName;

	
	@Column(name = "store_name")
	@NotBlank(message="Please enter store name!")
	private String storeName;
		
	@NotBlank(message="Please enter email address!")
	private String email;
	
	@Column(name = "contact_number")
	@NotBlank(message="Please enter contact number!")
	private String contactnumber;
	
	@NotBlank(message="Please enter password!")
	private String password;
	
	private boolean enabled = true;
	
	@Column(name = "is_active")
	private boolean active = true;


	//confirm password transient field
	
	@Transient
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	/*-------------*/

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
		

		/*--------------*/
	@Override
	public String toString() {
		return "Supplier [id=" + id + ",supplierName=" + supplierName + ", storeName=" + storeName + ", email=" + email + ", contactnumber="
				+ contactnumber + ", password=" + password + ", enabled=" + enabled + ", active=" + active
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	}
