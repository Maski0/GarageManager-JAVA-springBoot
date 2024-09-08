package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Payments;

import java.time.LocalDate;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "paymentId")
public class Payment {
	
	@Id
	@GeneratedValue
	private Integer paymentId;
	@JsonBackReference("Booking-Payment")
	@ManyToOne()
	@JoinColumn(name="bookingId")
	private Booking booking;
	
	private LocalDate paymentDate;
	
	private Integer paymentAmount;
	
	private String paymentMethod;
	
	private String paymentStatus;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + paymentId + ", booking=" + booking + ", paymentDate=" + paymentDate
				+ ", paymentAmount=" + paymentAmount + ", paymentMethod=" + paymentMethod + ", paymentStatus="
				+ paymentStatus + "]";
	}

	public void UpdateValues(Payment payment) {
		this.booking = (payment.getBooking() != null) ? payment.getBooking() : this.booking;
		this.paymentDate = (payment.getPaymentDate() != null) ? payment.getPaymentDate() : this.paymentDate;
		this.paymentAmount = (payment.getPaymentAmount() != null) ? payment.getPaymentAmount() : this.paymentAmount;
		this.paymentMethod = (payment.getPaymentMethod() != null) ? payment.getPaymentMethod() : this.paymentMethod;
		this.paymentStatus = (payment.getPaymentStatus() != null) ? payment.getPaymentStatus() : this.paymentStatus;
	}

}
