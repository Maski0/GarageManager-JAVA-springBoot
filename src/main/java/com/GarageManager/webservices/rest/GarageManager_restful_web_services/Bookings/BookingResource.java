package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.BookingRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

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
	
	
	@PostMapping("/bookings")
	public ResponseEntity<Booking> saveBooking(@Valid @RequestBody Booking booking) {
		Booking saveBooking = repository.save(booking);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveBooking.getBooking_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	

}
