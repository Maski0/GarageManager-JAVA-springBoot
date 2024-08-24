package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
public class EmployeeResource {
	
	private EmployeeRepository repository;
	
	public EmployeeResource(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	// Get All Employees
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees(){
		return repository.findAll();
	}
	
	// Get Specific Employee
	@GetMapping("/employees/{employeeID}")
	public Employee retrieveEmployees(@PathVariable Integer employeeID){
		Optional<Employee> employee = repository.findById(employeeID);
		if(employee.isEmpty())
			throw new NotFoundException("EmployeeID:" + employeeID);
		return employee.get();
	}
	
	// Delete Specific Employee
	@DeleteMapping("/employees/{employeeID}")
	public void deleteEmployees(@PathVariable Integer employeeID){
		repository.deleteById(employeeID);
	}
	
	// Create Employee
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee saveEmployee = repository.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveEmployee.getEmployee_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	// Create Employee
		@PostMapping("/employees/test")
		public Employee TestEmployy(@Valid @RequestBody Employee employee) {
			System.out.println("Employee " + employee);
			return employee;
		}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@Valid @RequestBody Employee employee) {
		Employee existingEmployee = repository.findById(employee.getEmployee_id()).orElseThrow(
				() -> new NotFoundException("Employee ID: "+ employee.getEmployee_id()));
		existingEmployee.UpdateValues(employee);
		return repository.save(existingEmployee);
	}

}
