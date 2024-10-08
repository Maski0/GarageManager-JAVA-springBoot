package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services;

import java.util.List;
import java.util.stream.Collectors;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;

public class ServiceCustomDTOs {
	
	
	public static class GetServiceDTO {
		private Integer serviceId;
	    private String serviceName;
	    private String serviceDescription;
	    private Integer serviceDuration;
	    private List<Integer> bookings;
	    
	    public static GetServiceDTO fromEntity(Service service) {
	    	GetServiceDTO dto = new GetServiceDTO();
	        dto.setServiceId(service.getServiceId());
	        dto.setServiceName(service.getServiceName());
	        dto.setServiceDescription(service.getServiceDescription());
	        dto.setServiceDuration(service.getServiceDuration());
	        
	        if (service.getBookings() != null) {
	            dto.setBookings(service.getBookings().stream()
	                .map(Booking::getBookingId)
	                .collect(Collectors.toList()));
	        }
	        
	        return dto;
	    }

		public Integer getServiceId() {
			return serviceId;
		}

		public void setServiceId(Integer serviceId) {
			this.serviceId = serviceId;
		}

		public String getServiceName() {
			return serviceName;
		}

		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}

		public String getServiceDescription() {
			return serviceDescription;
		}

		public void setServiceDescription(String serviceDescription) {
			this.serviceDescription = serviceDescription;
		}

		public Integer getServiceDuration() {
			return serviceDuration;
		}

		public void setServiceDuration(Integer serviceDuration) {
			this.serviceDuration = serviceDuration;
		}

		public List<Integer> getBookings() {
			return bookings;
		}

		public void setBookings(List<Integer> bookings) {
			this.bookings = bookings;
		}
	}

}
