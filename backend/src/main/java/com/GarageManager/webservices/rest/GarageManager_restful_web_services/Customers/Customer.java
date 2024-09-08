package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers;

import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer customerId;
	
	@Size(min=3, max=30,message = "Name Should have Atleast 3 characters")
	private String customer_name;

	@Size(max=30,message = "Address Should Not have More than 30 characters")
	private String address;
	
	@Email(regexp = ".+[@].+[\\.].+")
	private String e_mail;
	
	@NotNull
	private Long phoneNumber;
	
	@JsonManagedReference("Customer-Vehicle")
	@OneToMany(mappedBy = "customer")
	private List<Vehicle> vehicles;

	public Customer(Integer customerId,
			@Size(min = 3, max = 30, message = "Name Should have Atleast 3 characters") String customer_name,
			@Size(max = 30, message = "Address Should Not have More than 30 characters") String address,
			@Email(regexp = ".+[@].+[\\.].+") String e_mail, @NotNull long phoneNumber) {
		super();
		this.customerId = customerId;
		this.customer_name = customer_name;
		this.address = address;
		this.e_mail = e_mail;
		this.phoneNumber = phoneNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long ph_no) {
		this.phoneNumber = ph_no;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customerId + ", customer_name=" + customer_name + ", address=" + address
				+ ", e_mail=" + e_mail + ", ph_no=" + phoneNumber + "]";
	}

	protected Customer() {
		super();
	}

	public void UpdateValues(Customer customer) {
		this.customer_name = (customer.getCustomer_name() != null) ? customer.getCustomer_name() : this.customer_name;
		this.address = (customer.getAddress() != null) ? customer.getAddress() : this.address;
		this.e_mail = (customer.getE_mail() != null) ? customer.getE_mail() : this.e_mail;
		this.phoneNumber = (customer.getPhoneNumber() != null) ? customer.getPhoneNumber() : this.phoneNumber;
		this.vehicles = (!customer.getVehicles().isEmpty() || customer.getVehicles() != null) ? customer.getVehicles() : this.vehicles;
	}

}
