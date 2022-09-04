package com.example.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.FoodApplication.dto.FoodOrder;
import com.example.FoodApplication.repository.FoodOrderRepository;

@Repository
public class FoodOrderDAO {
	@Autowired
	FoodOrderRepository foodOrderRep;

	// save
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRep.save(foodOrder);
	}

	// update
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRep.save(foodOrder);

	}

	// delete
	public FoodOrder deleteFoodOrder(int id) {
		FoodOrder foodOrder = getFoodOrderById(id).get();
		foodOrderRep.delete(foodOrder);
		return foodOrder;
	}

	// getById
	public Optional<FoodOrder> getFoodOrderById(int id) {
		return foodOrderRep.findById(id);
	}

	// find all 
	public List<FoodOrder> findAllFoodOrders() {
		return foodOrderRep.findAll();
	}

}
