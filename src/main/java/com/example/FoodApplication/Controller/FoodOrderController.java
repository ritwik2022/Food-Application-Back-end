package com.example.FoodApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.FoodApplication.Service.FoodOrderService;
import com.example.FoodApplication.dao.FoodOrderDAO;

import com.example.FoodApplication.dto.FoodOrder;
import com.example.FoodApplication.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FoodOrderController {
	
	@Autowired
	FoodOrderDAO foodOrderDAO;
	
    @Autowired
    FoodOrderService foodOrderService;
	
	@PostMapping("/savefood")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@DeleteMapping("/deletefood")
	public ResponseEntity<ResponseStructure<FoodOrder>>  deleteFoodOrder(@RequestParam int id) {
		return foodOrderService.deleteFoodOrder(id);
	}

	@GetMapping("/getbyidfood/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(@PathVariable int id) {
		return foodOrderService.getFoodOrderById(id);
	}

	@GetMapping("/allfood")
	public List<FoodOrder> findAllFoodOrders() {
		return foodOrderDAO.findAllFoodOrders();
	}
	
	@PutMapping("/updatefood/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@PathVariable int id) {
		return foodOrderService.udpateFoodOrder(foodOrder, id);
	}

	
}
