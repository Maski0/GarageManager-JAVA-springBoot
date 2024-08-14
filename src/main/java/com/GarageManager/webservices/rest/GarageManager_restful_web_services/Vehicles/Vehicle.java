package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue
	private Integer vehicle_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	@JsonIgnore
	private Customer customer;
	
	@NotNull
	private String make;
	
	@NotNull
	private String model;
	
	@NotNull
	private String VehiclePlateNumber;
	
	@OneToMany(mappedBy = "vehicle")
	@JsonIgnore
	private List<Booking> bookings;

	public Integer getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehiclePlateNumber() {
		return VehiclePlateNumber;
	}

	public void setVehiclePlateNumber(String vehiclePlateNumber) {
		VehiclePlateNumber = vehiclePlateNumber;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", customer=" + customer + ", make=" + make + ", model=" + model
				+ ", VehiclePlateNumber=" + VehiclePlateNumber + "]";
	}

}
