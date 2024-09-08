package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicleId")
public class Vehicle {
	
	@Id
	@GeneratedValue
	private Integer vehicleId;
	
	@JsonBackReference("Customer-Vehicle")
	@ManyToOne()
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@NotNull
	private String make;
	
	@NotNull
	private String model;
	
	@NotNull
	private String VehiclePlateNumber;
	
	@JsonBackReference("Vehicle-Booking")
	@OneToMany(mappedBy = "vehicle", orphanRemoval = true)
	private List<Booking> bookings;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicleId + ", customer=" + customer + ", make=" + make + ", model=" + model
				+ ", VehiclePlateNumber=" + VehiclePlateNumber + ", bookings=" + bookings + "]";
	}
	
	public void UpdateValues(Vehicle vehicle) {
		
		this.make = (vehicle.getMake() != null) ? vehicle.getMake() : this.make;
		this.model = (vehicle.getModel() != null) ? vehicle.getModel() : this.model;
		this.VehiclePlateNumber = (vehicle.getVehiclePlateNumber() != null) ? vehicle.getVehiclePlateNumber() : this.VehiclePlateNumber;
		this.customer = (vehicle.getCustomer() != null) ? vehicle.getCustomer() : this.customer;
		this.bookings = (!vehicle.getBookings().isEmpty() || vehicle.getBookings() != null ) ? vehicle.getBookings() : this.bookings;
	}

}
