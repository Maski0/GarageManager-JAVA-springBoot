package com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Customers.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> findByPhoneNumber(long PhoneNumber);
}
