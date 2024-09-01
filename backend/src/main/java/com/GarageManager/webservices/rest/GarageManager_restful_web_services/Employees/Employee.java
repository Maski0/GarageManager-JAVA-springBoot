package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Employees;

import java.time.LocalDate;
import java.util.List;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employee_id")
public class Employee {
	
	protected Employee() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employee_id; 
	
	@Size(min=3, max=30,message = "Name Should have Atleast 3 characters")
	private String employee_name;
	
	@Size(max=30,message = "Address Should Not have More than 30 characters")
	private String address;
	
	@Email(regexp = ".+[@].+[\\.].+")
	private String e_mail;
	
	@NotNull
	private Long phoneNumber;
	
	private LocalDate date_of_Joining;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "employees")
    private List<Booking> bookings;
	
	
	public Employee(Integer employee_id,
			String employee_name,
			String address,
			String e_mail,
			Long ph_no,
			LocalDate date_of_Joining) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.address = address;
		this.e_mail = e_mail;
		this.phoneNumber = ph_no;
		this.date_of_Joining = date_of_Joining;
	}


	public Integer getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getE_mail() {
		return e_mail;
	}


	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}


	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long ph_no) {
		this.phoneNumber = ph_no;
	}


	public LocalDate getDate_of_Joining() {
		return date_of_Joining;
	}


	public void setDate_of_Joining(LocalDate date_of_Joining) {
		this.date_of_Joining = date_of_Joining;
	}


	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", address=" + address
				+ ", e_mail=" + e_mail + ", ph_no=" + phoneNumber + ", date_of_Joining=" + date_of_Joining + ", bookings="
				+ bookings + "]";
	}


	public List<Booking> getBookings() {
		return bookings;
	}


	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	
	public void UpdateValues(Employee employee) {
		this.employee_name = (employee.getEmployee_name() != null) ? employee.getEmployee_name() : this.employee_name;
		this.address = (employee.getAddress() != null) ? employee.getAddress() : this.address;
		this.e_mail = (employee.getE_mail() != null) ? employee.getE_mail() : this.e_mail;
		this.phoneNumber = (employee.getPhoneNumber() != null) ? employee.getPhoneNumber() : this.phoneNumber;
		this.date_of_Joining = (employee.getDate_of_Joining() != null) ? employee.getDate_of_Joining() : this.date_of_Joining;
		this.bookings = (!employee.getBookings().isEmpty() || employee.getBookings() != null) ? employee.getBookings() : this.bookings;
	}
	

}
