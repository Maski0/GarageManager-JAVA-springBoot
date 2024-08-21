package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Payments;

import java.time.LocalDate;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private Integer payment_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference("Booking-Payment")
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	private LocalDate paymentDate;
	
	private Integer paymentAmount;
	
	private String paymentMethod;
	
	private String paymentStatus;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
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
		return "Payment [payment_id=" + payment_id + ", booking=" + booking + ", paymentDate=" + paymentDate
				+ ", paymentAmount=" + paymentAmount + ", paymentMethod=" + paymentMethod + ", paymentStatus="
				+ paymentStatus + "]";
	}

}
