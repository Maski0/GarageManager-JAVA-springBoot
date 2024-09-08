package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.Services.ServiceCustomDTOs.GetServiceDTO;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.exception.NotFoundException;
import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.ServiceRepository;

import jakarta.validation.Valid;

@RestController
public class ServiceResource {
	
	private ServiceRepository repository;
	
	public ServiceResource(ServiceRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/services")
	public List<GetServiceDTO> getAllServices(
			@RequestParam(required = false) Optional<Integer> pageNo,
			@RequestParam(required = false) Optional<Integer> pageSize){
		
		if(pageNo.isPresent() && pageSize.isPresent()) {
			PageRequest pageRequest = PageRequest.of(pageNo.get(), pageSize.get(), Sort.by("bookingId").descending());
			Slice<Service> service = repository.findAll(pageRequest);
			return service.getContent().stream()
					.map(GetServiceDTO::fromEntity)
					.collect(Collectors.toList());
		}
		
		return repository.findAll().stream()
				.map(GetServiceDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	@PostMapping("/services")
	public ResponseEntity<Service> createService(@Valid @RequestBody Service service){
		Service saveService = repository.save(service);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{serviceID}").buildAndExpand(saveService.getServiceId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/services")
	public Service updateService(@Valid @RequestBody Service service) {
		Service existingService = repository.findById(service.getServiceId()).orElseThrow(
				() -> new NotFoundException("Service ID: "+ service.getServiceId()));
		existingService.UpdateValues(service);
		return repository.save(existingService);
	}
	
	@DeleteMapping("/services/{service_ID}")
	public void deleteService(@PathVariable Integer service_ID) {
		repository.deleteById(service_ID);
	}
	

}
