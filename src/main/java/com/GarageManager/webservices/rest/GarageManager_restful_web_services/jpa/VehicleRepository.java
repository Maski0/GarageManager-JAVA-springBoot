package com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Vehicles.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
