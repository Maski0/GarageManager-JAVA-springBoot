package com.GarageManager.webservices.rest.GarageManager_restful_web_services.Inventory;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "itemId")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer itemId;
	
	private String itemName;
	
	private String description;
	
	private Integer quantity;
	
	private Float unitPrice;
	
	private String category;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Inventory [itemId=" + itemId + ", itemName=" + itemName + ", description=" + description + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", category=" + category + "]";
	}
	

}
