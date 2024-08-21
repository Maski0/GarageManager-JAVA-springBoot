package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers.Customer;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.CustomerRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.VehicalRepository;

import jakarta.validation.Valid;

@RestController

public class VehicleResource {
	
	private VehicalRepository repository;
	private CustomerRepository customerRepository;
	
	public VehicleResource(VehicalRepository repository, CustomerRepository customerRepository) {
		this.repository = repository;
		this.customerRepository = customerRepository;
	}
	
	
	// Get All Vehicles
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles(){
		return repository.findAll();
	}
	
	// Create A Vehicle for the Customer ID
	@PostMapping("/vehicles/{Customer_PhoneNumber}")
	public ResponseEntity<Vehicle> createVehicle(@PathVariable long Customer_PhoneNumber, @Valid @RequestBody Vehicle vehicle){
		Customer customer = customerRepository.findByPhoneNumber(Customer_PhoneNumber).orElseThrow(
				() -> new NotFoundException("Customer_PhoneNumber:" + Customer_PhoneNumber));
		
		vehicle.setCustomer(customer);
		Vehicle saveVehicle = repository.save(vehicle);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveVehicle.getVehicle_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/vehicles")
	public Vehicle updateVehicle(@Valid @RequestBody Vehicle vehicle) {
		Vehicle exisitingVehicle = repository.findById(vehicle.getVehicle_id()).orElseThrow(
				() -> new NotFoundException("Vehicle ID: "+ vehicle.getVehicle_id()));
		exisitingVehicle.UpdateValues(vehicle);
		return repository.save(exisitingVehicle);
	}
	
	
	@DeleteMapping("/vehicles/{vehicle_ID}")
	public void deleteVehicle(@PathVariable Integer vehicle_ID) {
		repository.deleteById(vehicle_ID);
	}
	
}
