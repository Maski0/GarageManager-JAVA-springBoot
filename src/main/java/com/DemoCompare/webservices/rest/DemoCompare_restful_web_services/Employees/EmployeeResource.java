package com.DemoCompare.webservices.rest.DemoCompare_restful_web_services.Employees;

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

import jakarta.validation.Valid;

@RestController
public class EmployeeResource {
	
	private EmployeeDaoService service;
	
	public EmployeeResource(EmployeeDaoService service) {
		this.service = service;
	}
	
	// Get All Employees
	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees(){
		return service.findAll();
	}
	// Get Specific Employee
	@GetMapping("/employees/{employeeID}")
	public Employee retrieveEmployees(@PathVariable Integer employeeID){
		Employee employee = service.GetEmployee(employeeID);
		if(employee == null)
			throw new EmployeeNotFoundException("EmployeeID:" + employeeID);
		return employee;
	}
	
	// Delete Specific Employee
	@DeleteMapping("/employees/{employeeID}")
	public void deleteEmployees(@PathVariable Integer employeeID){
		service.DeleteEmployee(employeeID);
	}
	
	// Create Employee
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee saveEmployee = service.save(employee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeID}").buildAndExpand(saveEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
