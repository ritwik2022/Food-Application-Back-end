package com.example.FoodApplication.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApplication.ExceptionHandle.IdNotFoundException;
import com.example.FoodApplication.dao.FoodOrderDAO;

import com.example.FoodApplication.dto.FoodOrder;
import com.example.FoodApplication.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDAO foodOrderDAO;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {

		ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
		structure.setMsg("FoodOrder saved Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(foodOrderDAO.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
		structure.setMsg("FoodOrder Deleted Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodOrderDAO.deleteFoodOrder(id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		Optional<FoodOrder> optional = foodOrderDAO.getFoodOrderById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}

		else {
			ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
			structure.setMsg("FoodOrder Found Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
		}

	}

	public ResponseEntity<ResponseStructure<FoodOrder>> udpateFoodOrder(FoodOrder foodOrder, int id) {

		FoodOrder order = foodOrderDAO.updateFoodOrder(foodOrder);
		ResponseStructure<FoodOrder> structure = new ResponseStructure<FoodOrder>();
		if (order == null) {
			structure.setMsg("Not found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(order);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.OK);
		} else {
			structure.setMsg("Updated Succesfully");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setT(order);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure, HttpStatus.NOT_FOUND);
		}

	}

}
