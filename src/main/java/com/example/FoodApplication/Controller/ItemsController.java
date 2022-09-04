package com.example.FoodApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodApplication.dao.ItemsDAO;
import com.example.FoodApplication.dto.Items;

@RestController
public class ItemsController {
	 @Autowired
	 ItemsDAO itemsDAO;
	 
	 @PutMapping("/itemscon")
	 public Items saveItems(@RequestBody Items items) {
		 return itemsDAO.saveItem(items);
	 }

}
