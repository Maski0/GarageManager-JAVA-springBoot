package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.CustomerRepository;

import jakarta.validation.Valid;


@RestController
public class CustomerResource {
	
	private CustomerRepository repository;
	
	public CustomerResource(CustomerRepository repository) {
		this.repository = repository;
	}
	
	// Get All Employees
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return repository.findAll();
	}
	
	// Get Specific Employee
	@GetMapping("/customers/{customerPhone_Number}")
	public Customer retrieveEmployees(@PathVariable long customerPhone_Number){
		Optional<Customer> employee = repository.findByPhoneNumber(customerPhone_Number);
		if(employee.isEmpty())
			throw new NotFoundException("Customer Ph_no:" + customerPhone_Number);
		return employee.get();
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
		Customer saveCustomer = repository.save(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveCustomer.getCustomer_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	// Delete Specific Customer
	@DeleteMapping("/customers/{CustomerID}")
	public void deleteEmployees(@PathVariable Integer CustomerID){
		repository.deleteById(CustomerID);
	}

}
