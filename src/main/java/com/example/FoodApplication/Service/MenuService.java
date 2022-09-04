package com.example.FoodApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.FoodApplication.dao.MenuDAO;
import com.example.FoodApplication.dto.Menu;
import com.example.FoodApplication.util.ResponseStructure;

@Service
public class MenuService 
{
	@Autowired
	MenuDAO menuDAO;
	
	public ResponseEntity<ResponseStructure<List<Menu>>> findAllMenu() {
		ResponseStructure<List<Menu>> structure = new ResponseStructure<List<Menu>>();
		structure.setMsg("Menu Found Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(menuDAO.findAllMenu());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(structure, HttpStatus.OK);
	}



}
