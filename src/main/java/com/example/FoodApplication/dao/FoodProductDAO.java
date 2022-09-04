package com.example.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.FoodProduct;
import com.example.FoodApplication.repository.FoodProductRepository;

@Repository
public class FoodProductDAO {
	@Autowired
	FoodProductRepository foodProductRep;
	
	//save
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return foodProductRep.save(foodProduct);
	}
	
	// update
	 	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
	 		return foodProductRep.save(foodProduct);

	 	}

	 	// delete
	 	public FoodProduct deleteFoodProduct(int id) {
	 		FoodProduct foodProduct= getFoodProductById(id).get();
	 	    foodProductRep.delete(foodProduct);
	 		return foodProduct;
	 	}
	 	
	   //getById
	 	public Optional<FoodProduct> getFoodProductById(int id) {
	 		return foodProductRep.findById(id);
	 	}
	 	
	   //find all Admins
	 	public List<FoodProduct> findAllFoodProducts(){
	 		return foodProductRep.findAll();
	 	}


}
