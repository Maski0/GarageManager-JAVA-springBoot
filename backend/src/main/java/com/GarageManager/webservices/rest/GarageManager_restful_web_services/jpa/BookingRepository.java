package com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Bookings.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	List<Booking> findBybookingIdGreaterThan(Integer id);

}
