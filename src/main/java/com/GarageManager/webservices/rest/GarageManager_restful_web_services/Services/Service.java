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
	
	private Integer serviceDuration;
	
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

	public Integer getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(Integer servicDuration) {
		this.serviceDuration = servicDuration;
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
				+ serviceDescription + ", servicDuration=" + serviceDuration + ", bookings=" + bookings + "]";
	}

	public void UpdateValues(Service service) {
		this.serviceName = (service.getServiceName() != null) ? service.getServiceName() : this.serviceName;
		this.serviceDescription = (service.getServiceDescription() != null) ? service.getServiceDescription() : this.serviceDescription;
		this.serviceDuration = (service.getServiceDuration() != null) ? service.getServiceDuration() : this.service_id;
		this.bookings = (service.getBookings() != null || service.getBookings().isEmpty()) ? service.getBookings() : this.bookings;
	}
	
	

}
