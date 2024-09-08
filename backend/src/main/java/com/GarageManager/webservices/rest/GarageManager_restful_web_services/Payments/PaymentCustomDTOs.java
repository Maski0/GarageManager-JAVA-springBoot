package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Payments;

import java.time.LocalDate;

public class PaymentCustomDTOs {
	
	public static class GetPaymentDTO {
		 private Integer paymentId;
		 private LocalDate paymentDate;
		 private Integer paymentAmount;
		 private String paymentMethod;
		 private String paymentStatus;
		 private Integer booking;
		 
		 
		 public static GetPaymentDTO fromEntity(Payment payment) {
			 	GetPaymentDTO dto = new GetPaymentDTO();
		        dto.setPaymentId(payment.getPaymentId());
		        dto.setPaymentDate(payment.getPaymentDate());
		        dto.setPaymentAmount(payment.getPaymentAmount());
		        dto.setPaymentMethod(payment.getPaymentMethod());
		        dto.setPaymentStatus(payment.getPaymentStatus());
		        dto.setBooking(payment.getBooking().getBookingId());
		        return dto;
		    }

		public Integer getPaymentId() {
			return paymentId;
		}


		public void setPaymentId(Integer paymentId) {
			this.paymentId = paymentId;
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


		public Integer getBooking() {
			return booking;
		}


		public void setBooking(Integer booking) {
			this.booking = booking;
		}
		 
		 
	}

}
