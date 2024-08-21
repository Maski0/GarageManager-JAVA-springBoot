package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services;

import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Service {
	
	@Id
	@GeneratedValue
	private Integer service_id;
	
	@NotNull
	private String serviceName;
	
	private String serviceDescription;
	
	private Integer servicDuration;
	
	@OneToMany(mappedBy = "service", orphanRemoval = true)
	@JsonManagedReference("Service-Booking")
	private List<Booking> bookings;

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Integer getServicDuration() {
		return servicDuration;
	}

	public void setServicDuration(Integer servicDuration) {
		this.servicDuration = servicDuration;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", serviceName=" + serviceName + ", serviceDescription="
				+ serviceDescription + ", servicDuration=" + servicDuration + ", bookings=" + bookings + "]";
	}
	
	

}
