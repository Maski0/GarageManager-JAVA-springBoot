package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services;

import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "service_id")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serviceId;
	
	@NotNull
	private String serviceName;
	
	private String serviceDescription;
	
	private Integer serviceDuration;
	
	@OneToMany(mappedBy = "service", orphanRemoval = true)
	@JsonBackReference("Service-Booking")
	private List<Booking> bookings;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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
		return "Service [service_id=" + serviceId + ", serviceName=" + serviceName + ", serviceDescription="
				+ serviceDescription + ", servicDuration=" + serviceDuration + ", bookings=" + bookings + "]";
	}

	public void UpdateValues(Service service) {
		this.serviceName = (service.getServiceName() != null) ? service.getServiceName() : this.serviceName;
		this.serviceDescription = (service.getServiceDescription() != null) ? service.getServiceDescription() : this.serviceDescription;
		this.serviceDuration = (service.getServiceDuration() != null) ? service.getServiceDuration() : this.serviceId;
		this.bookings = (!service.getBookings().isEmpty() || service.getBookings() != null) ? service.getBookings() : this.bookings;
	}
	
	

}
