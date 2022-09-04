package com.example.FoodApplication.dto;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String odrerTime;
	private String deliveryTime;
	private String customerName;
	private String customerNumber;
	private int totalPrize;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Items> items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOdrerTime() {
		return odrerTime;
	}

	public void setOdrerTime(String odrerTime) {
		this.odrerTime = odrerTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(int totalPrize) {
		this.totalPrize = totalPrize;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	


	

}
