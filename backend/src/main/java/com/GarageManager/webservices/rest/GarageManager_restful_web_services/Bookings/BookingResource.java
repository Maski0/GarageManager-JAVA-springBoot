package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.BookingCustomDTOs.CreateBookingDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.BookingCustomDTOs.GetBookingDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees.Employee;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services.Service;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.BookingRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.EmployeeRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.ServiceRepository;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.VehicleRepository;

import jakarta.validation.Valid;

@RestController
public class BookingResource {
	
	private BookingRepository repository;
	private EmployeeRepository employeeRepository;
	private VehicleRepository vehicleRepository;
	private ServiceRepository serviceRepository;
	
	
	
	public BookingResource(
			BookingRepository repository, 
			EmployeeRepository employeeRepository, 
			VehicleRepository vehicleRepository, 
			ServiceRepository serviceRepository) {
		
		this.repository = repository;
		this.employeeRepository = employeeRepository;
		this.vehicleRepository = vehicleRepository;
		this.serviceRepository = serviceRepository;
		
	}
	
	@GetMapping("/bookings")
	public List<GetBookingDTO> getAllBookings(
			@RequestParam(required = false) Optional<Integer> afterId,
			@RequestParam(required = false) Optional<Integer> pageNo,
			@RequestParam(required = false) Optional<Integer> pageSize){
		
		if(afterId.isPresent()) {
			return repository.findBybookingIdGreaterThan(afterId.get()).stream()
					.map(GetBookingDTO::fromEntity)
					.collect(Collectors.toList());
		}
		
		if(pageNo.isPresent() && pageSize.isPresent()) {
			PageRequest pageRequest = PageRequest.of(pageNo.get(), pageSize.get(), Sort.by("bookingId").descending());
			Slice<Booking> booking = repository.findAll(pageRequest);
			return booking.getContent().stream()
					.map(GetBookingDTO::fromEntity)
					.collect(Collectors.toList());
		}
		
		return repository.findAll().stream()
				.map(GetBookingDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/bookings/{booking_ID}")
	public GetBookingDTO getBookingByID(@PathVariable Integer booking_ID) {
		Booking existingBooking = repository.findById(booking_ID).orElseThrow(
				() -> new NotFoundException("Booking_ID: "+ booking_ID));
		
		return GetBookingDTO.fromEntity(existingBooking);
	}
	
	
	@PostMapping("/bookings/{Vehicle_ID}/{Service_ID}/{Employee_ids}")
	public Booking saveBooking(
			@PathVariable Integer Vehicle_ID, 
			@PathVariable Integer Service_ID,
			@PathVariable List<Integer> Employee_ids, 
			@Valid @RequestBody CreateBookingDTO bookingDTO) {
		
		Booking booking = new Booking();
				
		booking = bookingDTO.covertToBooking(booking);
		
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
	
	
	
	// /bookings?Booking_ID=1&Vehicle_ID=1&Service_ID=2&Employee_ids=1,2    To Update ALL (requestParam)
	
	@PutMapping("/bookings/{Booking_ID}")
	public Booking UpdateBooking(
			@PathVariable Integer Booking_ID,
			@RequestParam(required = false)  Optional<Integer> Vehicle_ID, 
			@RequestParam(required = false)  Optional<Integer>Service_ID,
			@RequestParam(required = false)  Optional<List<Integer>> Employee_ids, 
			@Valid @RequestBody(required = false) CreateBookingDTO bookingDTO) {
		
		Booking booking = repository.findById(Booking_ID).orElseThrow(
				() -> new NotFoundException("Booking_ID: " + Booking_ID));
		
		if(Vehicle_ID.isPresent()) {
			Vehicle vehicle = vehicleRepository.findById(Vehicle_ID.get()).orElseThrow(
					() -> new NotFoundException("Vehicle_Id :" + Vehicle_ID));
			booking.setVehicle(vehicle);
		}
		
		if(Service_ID.isPresent()) {
			Service service = serviceRepository.findById(Service_ID.get()).orElseThrow(
					() -> new NotFoundException("Service_ID :" + Service_ID));
			booking.setService(service);
		}
		
		if(Employee_ids.isPresent()) {
			List<Employee> employees = new ArrayList<Employee>();
			employees = employeeRepository.findAllById(Employee_ids.get());
			booking.setEmployees(employees);
		}
		
		booking = bookingDTO.covertToBooking(booking);
		
		return repository.save(booking);
	}
	
	
	@DeleteMapping("/bookings/{booking_ID}")
	public void deleteBookingByID(@PathVariable Integer booking_ID) {
		repository.deleteById(booking_ID);
	}
	
	

}
