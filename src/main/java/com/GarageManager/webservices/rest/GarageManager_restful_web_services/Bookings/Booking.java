package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.time.LocalDate;
import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees.Employee;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Payments.Payment;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services.Service;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer booking_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_id")
	@JsonBackReference("Vehicle-Booking")
	private Vehicle vehicle;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "booking_employee",
        joinColumns = @JoinColumn(name = "booking_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
	private List<Employee> employees;
	
	@JsonBackReference("Service-Booking")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="service_id")
	private Service service;
	
	private LocalDate start_date;
	
	private LocalDate delivery_date;
	
	private String bookingStatus;
	
	private Integer servicePrice;
	
	private Integer totalAmountDue;
	
	@OneToMany(mappedBy = "booking")
	@JsonManagedReference("Booking-Payment")
	private List<Payment> payments;

	public Integer getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getDelivery_date() {
		return delivery_date;
	}

	public void setDelivery_date(LocalDate delivery_date) {
		this.delivery_date = delivery_date;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Integer getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Integer getTotalAmountDue() {
		return totalAmountDue;
	}

	public void setTotalAmountDue(Integer totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", vehicle=" + vehicle + ", employees=" + employees + ", service="
				+ service + ", start_date=" + start_date + ", delivery_date=" + delivery_date + ", bookingStatus="
				+ bookingStatus + ", servicePrice=" + servicePrice + ", totalAmountDue=" + totalAmountDue
				+ ", payments=" + payments + "]";
	}

}
