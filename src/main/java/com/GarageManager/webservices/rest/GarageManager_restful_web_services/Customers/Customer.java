package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers;

import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer customer_id; 
	
	@Size(min=3, max=30,message = "Name Should have Atleast 3 characters")
	private String customer_name;

	@Size(max=30,message = "Address Should Not have More than 30 characters")
	private String address;
	
	@Email(regexp = ".+[@].+[\\.].+")
	private String e_mail;
	
	@NotNull
	private long ph_no;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Vehicle> vehicles;

	public Customer(Integer customer_id,
			@Size(min = 3, max = 30, message = "Name Should have Atleast 3 characters") String customer_name,
			@Size(max = 30, message = "Address Should Not have More than 30 characters") String address,
			@Email(regexp = ".+[@].+[\\.].+") String e_mail, @NotNull long ph_no) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.address = address;
		this.e_mail = e_mail;
		this.ph_no = ph_no;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public long getPh_no() {
		return ph_no;
	}

	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", address=" + address
				+ ", e_mail=" + e_mail + ", ph_no=" + ph_no + "]";
	}
}
