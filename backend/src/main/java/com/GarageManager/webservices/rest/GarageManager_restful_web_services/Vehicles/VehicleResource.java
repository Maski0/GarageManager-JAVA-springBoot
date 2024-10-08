package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers.Customer;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.VehicleCustomDTOs.GetVehicleDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.CustomerRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.VehicleRepository;

import jakarta.validation.Valid;

@RestController
public class VehicleResource {
	
	private VehicleRepository repository;
	private CustomerRepository customerRepository;
	
	public VehicleResource(VehicleRepository repository, CustomerRepository customerRepository) {
		this.repository = repository;
		this.customerRepository = customerRepository;
	}
	
	
	// Get All Vehicles
	@GetMapping("/vehicles")
	public List<GetVehicleDTO> getAllVehicles(
			@RequestParam(required = false) Optional<Integer> pageNo,
			@RequestParam(required = false) Optional<Integer> pageSize){
		
		if(pageNo.isPresent() && pageSize.isPresent()) {
			PageRequest pageRequest = PageRequest.of(pageNo.get(), pageSize.get(), Sort.by("vehicleId").descending());
			Slice<Vehicle> vehicle = repository.findAll(pageRequest);
			return vehicle.getContent().stream()
					.map(GetVehicleDTO::fromEntity)
					.collect(Collectors.toList());
		}
		
		return repository.findAll().stream()
				.map(GetVehicleDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	// Create A Vehicle for the Customer ID
	@PostMapping("/vehicles/{Customer_PhoneNumber}")
	public ResponseEntity<Vehicle> createVehicle(@PathVariable long Customer_PhoneNumber, @Valid @RequestBody Vehicle vehicle){
		Customer customer = customerRepository.findByPhoneNumber(Customer_PhoneNumber).orElseThrow(
				() -> new NotFoundException("Customer_PhoneNumber:" + Customer_PhoneNumber));
		
		vehicle.setCustomer(customer);
		Vehicle saveVehicle = repository.save(vehicle);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveVehicle.getVehicleId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/vehicles")
	public Vehicle updateVehicle(@Valid @RequestBody Vehicle vehicle) {
		Vehicle exisitingVehicle = repository.findById(vehicle.getVehicleId()).orElseThrow(
				() -> new NotFoundException("Vehicle ID: "+ vehicle.getVehicleId()));
		exisitingVehicle.UpdateValues(vehicle);
		return repository.save(exisitingVehicle);
	}
	
	
	@DeleteMapping("/vehicles/{vehicle_ID}")
	public void deleteVehicle(@PathVariable Integer vehicle_ID) {
		repository.deleteById(vehicle_ID);
	}
	
}
