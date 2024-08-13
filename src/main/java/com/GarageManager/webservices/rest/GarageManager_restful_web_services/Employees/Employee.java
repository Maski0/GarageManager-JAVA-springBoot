package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	protected Employee() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer employee_id; 
	
	@Size(min=3, max=30,message = "Name Should have Atleast have 3 characters")
	private String employee_name;
	@Past(message= "Birth Date Should be in Past")
	private LocalDate birthDate;
	
	public Employee(Integer id, String name, LocalDate birthDate) {
		super();
		this.employee_id = id;
		this.employee_name = name;
		this.birthDate = birthDate;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer id) {
		this.employee_id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String name) {
		this.employee_name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Employees [id=" + employee_id + ", name=" + employee_name + ", birthDate=" + birthDate + "]";
	}

}
