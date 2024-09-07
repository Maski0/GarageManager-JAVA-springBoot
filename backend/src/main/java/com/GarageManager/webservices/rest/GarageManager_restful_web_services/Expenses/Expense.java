package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Expenses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "expenseId")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expenseId;
	
	private LocalDate exprenseDate;
	
	private String description;
	
	private Float amount;
	
	private String categoryl;

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public LocalDate getExprenseDate() {
		return exprenseDate;
	}

	public void setExprenseDate(LocalDate exprenseDate) {
		this.exprenseDate = exprenseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getCategoryl() {
		return categoryl;
	}

	public void setCategoryl(String categoryl) {
		this.categoryl = categoryl;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", exprenseDate=" + exprenseDate + ", description=" + description
				+ ", amount=" + amount + ", categoryl=" + categoryl + "]";
	}
	
	

}
