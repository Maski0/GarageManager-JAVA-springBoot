package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;

public class EmployeeCustomDTOs {
	
	public static class GetEmployeeDTO {
		
		private Integer employeeId;
	    private String employeeName;
	    private String address;
	    private String email;
	    private Long phoneNumber;
	    private LocalDate dateOfJoining;
	    
	    private List<Integer> bookings;
	    
	    public static GetEmployeeDTO fromEntity(Employee employee) {
	    	GetEmployeeDTO dto = new GetEmployeeDTO();
	        dto.setEmployeeId(employee.getEmployee_id());
	        dto.setEmployeeName(employee.getEmployee_name());
	        dto.setAddress(employee.getAddress());
	        dto.setEmail(employee.getE_mail());
	        dto.setPhoneNumber(employee.getPhoneNumber());
	        dto.setDateOfJoining(employee.getDate_of_Joining());
	        
	        dto.setBookings(employee.getBookings().stream()
	        		.map(Booking::getBookingId)
	        		.collect(Collectors.toList()));
	        
	        return dto;
	    }

		public Integer getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Integer employeeId) {
			this.employeeId = employeeId;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public LocalDate getDateOfJoining() {
			return dateOfJoining;
		}

		public void setDateOfJoining(LocalDate dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

		public List<Integer> getBookings() {
			return bookings;
		}

		public void setBookings(List<Integer> bookings) {
			this.bookings = bookings;
		}
		
	}

}
