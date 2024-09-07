package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.InventoryRepository;

import jakarta.validation.Valid;

@RestController
public class InventoryResource {
	
	private InventoryRepository repository;
	
	public InventoryResource(InventoryRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/inventory")
	public List<Inventory> getAllInventory(
			@RequestParam(required = false) Optional<Integer> pageNo,
			@RequestParam(required = false) Optional<Integer> pageSize) {
		
		if(pageNo.isPresent() && pageSize.isPresent()) {
			PageRequest pageRequest = PageRequest.of(pageNo.get(), pageSize.get(), Sort.by("itemId").descending());
			Slice<Inventory> inventory = repository.findAll(pageRequest);
			return inventory.getContent();
		}
		return repository.findAll();
	}
	
	@PostMapping("/inventory")
	public Inventory createInventory(@Valid @RequestBody Inventory inventory) {
		return repository.save(inventory);
	}
	
	@PutMapping("/inventory")
	public Inventory updateInventory(@Valid @RequestBody Inventory inventory) {
		return repository.save(inventory);
	}
	
	@DeleteMapping("/inventory/{itemID}")
	public void removeInventory(@RequestParam Integer itemID) {
		repository.deleteById(itemID);
	}

}
