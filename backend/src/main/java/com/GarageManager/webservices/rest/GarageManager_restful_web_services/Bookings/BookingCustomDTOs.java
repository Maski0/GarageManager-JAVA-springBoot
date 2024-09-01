package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees.EmployeeCustomDTOs.GetEmployeeDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Payments.PaymentCustomDTOs.GetPaymentDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services.ServiceCustomDTOs.GetServiceDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.VehicleCustomDTOs.GetVehicleDTO;


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
	
	public static class GetBookingDTO {
		
		private Integer bookingId;
		private GetVehicleDTO vehicle;
		private GetServiceDTO service;
		private List<GetEmployeeDTO> employees;
		private LocalDate start_date;
		private LocalDate delivery_date;
		private String bookingStatus;
		private Integer servicePrice;
		private Integer totalAmountDue;
		private List<GetPaymentDTO> payments;
	
		public Integer getBookingId() {
			return bookingId;
		}
		public void setBookingId(Integer bookingId) {
			this.bookingId = bookingId;
		}
		public GetVehicleDTO getVehicle() {
			return vehicle;
		}
		public void setVehicle(GetVehicleDTO vehicle) {
			this.vehicle = vehicle;
		}
		public List<GetEmployeeDTO> getEmployees() {
			return employees;
		}
		public void setEmployees(List<GetEmployeeDTO> employees) {
			this.employees = employees;
		}
		public GetServiceDTO getService() {
			return service;
		}
		public void setService(GetServiceDTO service) {
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
		public List<GetPaymentDTO> getPayments() {
			return payments;
		}
		public void setPayments(List<GetPaymentDTO> payments) {
			this.payments = payments;
		}
		
		public static GetBookingDTO fromEntity(Booking booking) {
			GetBookingDTO dto = new GetBookingDTO();
			dto.setBookingId(booking.getBookingId());
			dto.setBookingStatus(booking.getBookingStatus());
			dto.setDelivery_date(booking.getDelivery_date());
			dto.setServicePrice(booking.getServicePrice());
			dto.setStart_date(booking.getStart_date());
			dto.setTotalAmountDue(booking.getTotalAmountDue());
			
			dto.setService(GetServiceDTO.fromEntity(booking.getService()));
			dto.setVehicle(GetVehicleDTO.fromEntity(booking.getVehicle()));
			dto.setEmployees(booking.getEmployees().stream()
					.map(GetEmployeeDTO::fromEntity)
					.collect(Collectors.toList()));
			dto.setPayments(booking.getPayments().stream()
					.map(GetPaymentDTO::fromEntity)
					.collect(Collectors.toList()));
			
			return dto;
		}
		
	}
	
	
}


