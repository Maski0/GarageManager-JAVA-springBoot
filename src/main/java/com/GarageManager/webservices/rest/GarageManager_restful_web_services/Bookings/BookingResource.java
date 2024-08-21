package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.BookingRepository;

@RestController
public class BookingResource {
	
	private BookingRepository repository;
	
	
	public BookingResource(BookingRepository repository) {
		
		this.repository = repository;
	}
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings(){
		return repository.findAll();
	}

}
