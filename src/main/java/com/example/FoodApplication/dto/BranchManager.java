package com.example.FoodApplication.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BranchManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bname;
	private String bemail;
	public String bpass;

	@OneToMany(cascade = CascadeType.ALL)
	private List<FoodProduct> foodProduct;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Staff> staffs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBpass() {
		return bpass;
	}

	public void setBpass(String bpass) {
		this.bpass = bpass;
	}

	public List<FoodProduct> getFoodProduct() {
		return foodProduct;
	}

	public void setFoodProduct(List<FoodProduct> foodProduct) {
		this.foodProduct = foodProduct;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	
	
}
