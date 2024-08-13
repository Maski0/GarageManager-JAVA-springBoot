package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Booking {
	
	@Id
	@GeneratedValue
	private Integer booking_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_id")
	@JsonIgnore
	private Vehicle vehicle;
	
	
	

}
