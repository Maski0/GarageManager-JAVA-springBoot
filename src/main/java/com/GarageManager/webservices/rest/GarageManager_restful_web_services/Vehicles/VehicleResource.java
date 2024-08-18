package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.VehicalRepository;

import jakarta.validation.Valid;

@RestController
public class VehicleResource {
	
	private VehicalRepository repository;
	
	public VehicleResource(VehicalRepository repository) {
		this.repository = repository;
	}
	
	
	// Get All Vehicles
	@GetMapping("/Vehicles")
	public List<Vehicle> getAllVehicles(){
		return repository.findAll();
	}
	
	// 
	@PostMapping("/Vehicles")
	public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle vehicle){
		Vehicle saveVehicle = repository.save(vehicle);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveVehicle.getVehicle_id()).toUri();
		return ResponseEntity.created(location).build();
	}

}
