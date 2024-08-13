package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException( String message) {
		super(message);
	}
	

}
