package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoService {
	//JPA/Hibernate > Database
	//EmployeeDaoService > Static List
	
	private static List<Employee> employees = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		employees.add(new Employee(++userCount,"Adam","Hyderabad,India","someone@email.com",9563654715L,LocalDate.now().minusYears(25)));
		employees.add(new Employee(++userCount,"eve","Hyderabad,India","someone@email.com",7543554715L,LocalDate.now().minusYears(20)));
		employees.add(new Employee(++userCount,"jim","Hyderabad,India","someone@email.com",8963254715L,LocalDate.now().minusYears(10)));
	}
	
	public Employee save(Employee employee) {
		employee.setEmployee_id(++userCount);
		employees.add(employee);
		return employee;
	}
	
	// public List<User> FindAll()
	public List<Employee> findAll(){
		return employees;
	}
	
	public Employee GetEmployee(Integer employeeID) {
		Predicate<? super Employee> predicate = employee -> employee.getEmployee_id().equals(employeeID);
		return employees.stream().filter(predicate).findFirst().orElse(null);
	}
	public void DeleteEmployee(Integer employeeID) {
		Predicate<? super Employee> predicate = employee -> employee.getEmployee_id().equals(employeeID);
		employees.removeIf(predicate);
	}

}
