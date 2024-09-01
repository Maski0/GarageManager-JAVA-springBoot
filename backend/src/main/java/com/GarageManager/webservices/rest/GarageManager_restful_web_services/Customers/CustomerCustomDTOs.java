package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers;

import java.util.List;
import java.util.stream.Collectors;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.VehicleCustomDTOs.GetVehicleDTO;

public class CustomerCustomDTOs {
	
	public static class GetCustomerDTO {
		
		private Integer customerId;
	    private String customerName;
	    private String address;
	    private String email;
	    private Long phoneNumber;
	    private List<GetVehicleDTO> vehicles;
	    
	    public static GetCustomerDTO fromEntity(Customer customer) {
	    	GetCustomerDTO dto = new GetCustomerDTO();
	        dto.customerId = customer.getCustomer_id();
	        dto.customerName = customer.getCustomer_name();
	        dto.address = customer.getAddress();
	        dto.email = customer.getE_mail();
	        dto.phoneNumber = customer.getPhoneNumber();
	        
	        dto.vehicles = customer.getVehicles().stream()
	                               .map(GetVehicleDTO::fromEntity)
	                               .collect(Collectors.toList());
	        return dto;
	    }

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
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

		public List<GetVehicleDTO> getVehicles() {
			return vehicles;
		}

		public void setVehicles(List<GetVehicleDTO> vehicles) {
			this.vehicles = vehicles;
		}
		
	}

}
