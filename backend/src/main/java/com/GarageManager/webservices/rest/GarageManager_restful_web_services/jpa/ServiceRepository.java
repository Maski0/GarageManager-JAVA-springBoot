package com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services.Service;

public interface ServiceRepository extends JpaRepository<Service,Integer>{

}
