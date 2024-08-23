package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees.Employee;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services.Service;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.BookingRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.EmployeeRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.ServiceRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.VehicleRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class BookingResource {
	
	private BookingRepository repository;
	private EmployeeRepository employeeRepository;
	private VehicleRepository vehicleRepository;
	private ServiceRepository serviceRepository;
	
	
	public BookingResource(BookingRepository repository, EmployeeRepository employeeRepository, VehicleRepository vehicleRepository, ServiceRepository serviceRepository) {
		
		this.repository = repository;
		this.employeeRepository = employeeRepository;
		this.vehicleRepository = vehicleRepository;
		this.serviceRepository = serviceRepository;
		
	}
	
	@GetMapping("/bookings")
	public List<Booking> getAllBookings(){
		return repository.findAll();
	}
	
	
	@PostMapping("/bookings/{Vehicle_ID}/{Service_ID}/{Employee_ids}")
	public Booking saveBooking(
			@PathVariable Integer Vehicle_ID, 
			@PathVariable Integer Service_ID,
			@PathVariable List<Integer> Employee_ids, 
			@Valid @RequestBody Booking booking) {
		
		// Getting all the dependencies
		Vehicle vehicle = vehicleRepository.findById(Vehicle_ID).orElseThrow(
				() -> new NotFoundException("Vehicle_Id :" + Vehicle_ID));
		Service service = serviceRepository.findById(Service_ID).orElseThrow(
				() -> new NotFoundException("Service_ID :" + Service_ID));
		List<Employee> employees = new ArrayList<Employee>();
		employees = employeeRepository.findAllById(Employee_ids);
		
		if(employees.isEmpty())
			throw new NotFoundException("Employee_Ids :" + employees);
		
		booking.setVehicle(vehicle);
		booking.setService(service);
		booking.setEmployees(employees);
		
		return repository.save(booking);
	}
	
	
	

}
