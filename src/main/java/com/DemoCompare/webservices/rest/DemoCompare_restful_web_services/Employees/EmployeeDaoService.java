package com.DemoCompare.webservices.rest.DemoCompare_restful_web_services.Employees;

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
		employees.add(new Employee(++userCount,"Adam",LocalDate.now().minusYears(30)));
		employees.add(new Employee(++userCount,"eve",LocalDate.now().minusYears(25)));
		employees.add(new Employee(++userCount,"jim",LocalDate.now().minusYears(20)));
	}
	
	public Employee save(Employee employee) {
		employee.setId(++userCount);
		employees.add(employee);
		return employee;
	}
	
	// public List<User> FindAll()
	public List<Employee> findAll(){
		return employees;
	}
	
	public Employee GetEmployee(Integer employeeID) {
		Predicate<? super Employee> predicate = employee -> employee.getId().equals(employeeID);
		return employees.stream().filter(predicate).findFirst().orElse(null);
	}
	public void DeleteEmployee(Integer employeeID) {
		Predicate<? super Employee> predicate = employee -> employee.getId().equals(employeeID);
		employees.removeIf(predicate);
	}

}
