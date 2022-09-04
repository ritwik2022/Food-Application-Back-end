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

import com.example.FoodApplication.Service.FoodProductService;
import com.example.FoodApplication.dao.FoodProductDAO;

import com.example.FoodApplication.dto.FoodProduct;
import com.example.FoodApplication.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FoodProductController {
	
	@Autowired
	FoodProductDAO foodProductDAO;
	
	@Autowired
	FoodProductService foodProductService;
	
	
	@PostMapping("savefp")
	public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductDAO.saveFoodProduct(foodProduct);
	}
	
	@DeleteMapping("/deletefp")
	public ResponseEntity<ResponseStructure<FoodProduct>>  deleteFoodProduct(@RequestParam int id) {
		return foodProductService.deleteFoodProduct(id);
	}

	@GetMapping("/getbyidfp/{id}")
	public ResponseEntity<ResponseStructure<FoodProduct>> getFoodOrderById(@PathVariable int id) {
		return foodProductService.getFoodProductById(id);
	}

	@GetMapping("/allfp")
	public List<FoodProduct> findAllFoodProducts() {
		return foodProductDAO.findAllFoodProducts();
	}
	
	@PutMapping("/updatefp/{id}")
	public ResponseEntity<ResponseStructure<FoodProduct>> updateFoodProduct(@RequestBody FoodProduct foodProduct,@PathVariable int id) {
		return foodProductService.udpateFoodProduct(foodProduct, id);
	}


}
