package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.util.List;
import java.util.stream.Collectors;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;

public class VehicleCustomDTOs {
	
	public static class GetVehicleDTO {
		
		private Integer vehicleId;
	    private Integer customer;
	    private String make;
	    private String model;
	    private String vehiclePlateNumber;
	    private List<Integer> bookings;
	    
	    
	    public static GetVehicleDTO fromEntity(Vehicle vehicle) {
	    	GetVehicleDTO dto = new GetVehicleDTO();
	        dto.setVehicleId(vehicle.getVehicle_id());
	        dto.setMake(vehicle.getMake());
	        dto.setModel(vehicle.getModel());
	        dto.setVehiclePlateNumber(vehicle.getVehiclePlateNumber());
	        
	        dto.setCustomerId(vehicle.getCustomer().getCustomer_id());
	        
	        if (vehicle.getBookings() != null) {
	            dto.setBookings(vehicle.getBookings().stream()
	                            .map(Booking::getBookingId)
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


		public Integer getCustomer() {
			return customer;
		}


		public void setCustomerId(Integer customerId) {
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


		public List<Integer> getBookings() {
			return bookings;
		}


		public void setBookings(List<Integer> bookings) {
			this.bookings = bookings;
		}
		
	}

}
