package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.util.List;
import java.util.stream.Collectors;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.BookingCustomDTOs.GetBookingDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers.CustomerCustomDTOs.GetCustomerDTO;

public class VehicleCustomDTOs {
	
	public static class GetVehicleDTO {
		
		private Integer vehicleId;
	    private GetCustomerDTO customer;
	    private String make;
	    private String model;
	    private String vehiclePlateNumber;
	    private List<GetBookingDTO> bookings;
	    
	    
	    public static GetVehicleDTO fromEntity(Vehicle vehicle) {
	    	GetVehicleDTO dto = new GetVehicleDTO();
	        dto.setVehicleId(vehicle.getVehicle_id());
	        dto.setMake(vehicle.getMake());
	        dto.setModel(vehicle.getModel());
	        dto.setVehiclePlateNumber(vehicle.getVehiclePlateNumber());
	        
	        dto.setCustomerId(GetCustomerDTO.fromEntity(vehicle.getCustomer()));
	        
	        if (vehicle.getBookings() != null) {
	            dto.setBookings(vehicle.getBookings().stream()
	                            .map(GetBookingDTO::fromEntity)
	                            .collect(Collectors.toList()));
	        }
	        
	        return dto;
	    }


		public Integer getVehicleId() {
			return vehicleId;
		}


		public void setVehicleId(Integer vehicleId) {
			this.vehicleId = vehicleId;
		}


		public GetCustomerDTO getCustomer() {
			return customer;
		}


		public void setCustomerId(GetCustomerDTO customerId) {
			this.customer = customerId;
		}


		public String getMake() {
			return make;
		}


		public void setMake(String make) {
			this.make = make;
		}


		public String getModel() {
			return model;
		}


		public void setModel(String model) {
			this.model = model;
		}


		public String getVehiclePlateNumber() {
			return vehiclePlateNumber;
		}


		public void setVehiclePlateNumber(String vehiclePlateNumber) {
			this.vehiclePlateNumber = vehiclePlateNumber;
		}


		public List<GetBookingDTO> getBookings() {
			return bookings;
		}


		public void setBookings(List<GetBookingDTO> bookings) {
			this.bookings = bookings;
		}
		
	}

}
