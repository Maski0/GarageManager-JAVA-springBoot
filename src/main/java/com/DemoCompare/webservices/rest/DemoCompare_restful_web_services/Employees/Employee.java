package com.DemoCompare.webservices.rest.DemoCompare_restful_web_services.Employees;

import java.time.LocalDate;

public class Employee {
	
	private Integer id;
	private String name;
	private LocalDate birthDate;
	
	public Employee(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
