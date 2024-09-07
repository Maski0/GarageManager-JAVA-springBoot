package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Expenses;

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

import com.GarageManager.webservices.rest.GarageManager_restful_web_services.jpa.ExpenseRepository;

import jakarta.validation.Valid;

@RestController
public class ExpenseResource {
	
	private ExpenseRepository repository;
	
	public ExpenseResource(ExpenseRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpense(
			@RequestParam(required = false) Optional<Integer> pageNo,
			@RequestParam(required = false) Optional<Integer> pageSize) {
		
		if(pageNo.isPresent() && pageSize.isPresent()) {
			PageRequest pageRequest = PageRequest.of(pageNo.get(), pageSize.get(), Sort.by("itemId").descending());
			Slice<Expense> expense = repository.findAll(pageRequest);
			return expense.getContent();
		}
		return repository.findAll();
	}
	
	@PostMapping("/expenses")
	public Expense createExpense(@Valid @RequestBody Expense expense) {
		return repository.save(expense);
	}
	
	@PutMapping("/expenses")
	public Expense updateInventory(@Valid @RequestBody Expense expense) {
		return repository.save(expense);
	}
	
	@DeleteMapping("/expenses/{itemID}")
	public void removeInventory(@RequestParam Integer itemID) {
		repository.deleteById(itemID);
	}

}
