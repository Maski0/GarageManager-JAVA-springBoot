package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.time.LocalDate;
import java.util.Optional;


public class BookingCustomDTOs {
	
	public static class CreateBookingDTO {
		
		private LocalDate start_date;
		
		private LocalDate delivery_date;
		
		private String bookingStatus;
		
		private Integer servicePrice;
		
		private Integer totalAmountDue;
		
		public Booking covertToBooking(Booking booking) {
			Optional.ofNullable(start_date).ifPresent(booking::setStart_date);
		    Optional.ofNullable(delivery_date).ifPresent(booking::setDelivery_date);
		    Optional.ofNullable(bookingStatus).ifPresent(booking::setBookingStatus);
		    Optional.ofNullable(servicePrice).ifPresent(booking::setServicePrice);
		    Optional.ofNullable(totalAmountDue).ifPresent(booking::setTotalAmountDue);
			return booking;
		}

		@Override
		public String toString() {
			return "CreateBookingDTO [start_date=" + start_date + ", delivery_date=" + delivery_date
					+ ", bookingStatus=" + bookingStatus + ", servicePrice=" + servicePrice + ", totalAmountDue="
					+ totalAmountDue + "]";
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
	}
	
}


