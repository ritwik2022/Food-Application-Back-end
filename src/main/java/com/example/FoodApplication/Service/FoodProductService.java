package com.example.FoodApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApplication.ExceptionHandle.IdNotFoundException;

import com.example.FoodApplication.dao.FoodProductDAO;

import com.example.FoodApplication.dto.FoodProduct;
import com.example.FoodApplication.util.ResponseStructure;

@Service
public class FoodProductService {

	@Autowired
	FoodProductDAO foodProductDAO;

	// Save
	public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodOrder(FoodProduct foodProduct) {

		ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
		structure.setMsg("FoodProduct saved Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(foodProductDAO.saveFoodProduct(foodProduct));
		return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.CREATED);
	}

	// Delete
	public ResponseEntity<ResponseStructure<FoodProduct>> deleteFoodProduct(int id) {
		ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
		structure.setMsg("FoodProduct Deleted Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodProductDAO.deleteFoodProduct(id));
		return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
	}

	// Get by id
	public ResponseEntity<ResponseStructure<FoodProduct>> getFoodProductById(int id) {
		Optional<FoodProduct> optional = foodProductDAO.getFoodProductById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}

		else {
			ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
			structure.setMsg("FoodProduct Found Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
		}

	}

	// update
	public ResponseEntity<ResponseStructure<FoodProduct>> udpateFoodProduct(FoodProduct foodProduct, int id) {

		FoodProduct product = foodProductDAO.updateFoodProduct(foodProduct);
		ResponseStructure<FoodProduct> structure = new ResponseStructure<FoodProduct>();
		if (product == null) {
			structure.setMsg("Not found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(product);
			return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
		} else {
			structure.setMsg("Updated Succesfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(product);
			return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<List<FoodProduct>>> findAllFoodProduct() {
		ResponseStructure<List<FoodProduct>> structure = new ResponseStructure<List<FoodProduct>>();
		structure.setMsg("FoodProduct Found Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodProductDAO.findAllFoodProducts());
		return new ResponseEntity<ResponseStructure<List<FoodProduct>>>(structure, HttpStatus.OK);
	}

}
