package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Payments;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.BookingRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.PaymentRepository;

import jakarta.validation.Valid;


@RestController
public class PaymentResource {
	
	private PaymentRepository repository;
	private BookingRepository bookingRepository;
	
	
	public PaymentResource(PaymentRepository repository,BookingRepository bookingRepository) {
		this.repository = repository;
		this.bookingRepository = bookingRepository;
	}
	
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return repository.findAll();
	}
	
	// Create Payments Related to Booking ID
	@PostMapping("/payments/{booking_ID}")
	public ResponseEntity<Payment> createPayment(@PathVariable Integer booking_ID  ,@Valid @RequestBody Payment payment){
		
		Booking booking = bookingRepository.findById(booking_ID).orElseThrow(
				() -> new NotFoundException("Booking ID:" + booking_ID));
		payment.setBooking(booking);
		Payment savePayment = repository.save(payment);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{paymentID}").buildAndExpand(savePayment.getPayment_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/payments/{payment_ID}")
	public void deletePayment(@PathVariable Integer payment_ID) {
		repository.deleteById(payment_ID);
	}

}
