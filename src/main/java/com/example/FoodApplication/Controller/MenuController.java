package com.example.FoodApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodApplication.Service.MenuService;
import com.example.FoodApplication.dao.MenuDAO;

import com.example.FoodApplication.dto.Menu;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class MenuController {
	
	@Autowired
	MenuDAO menuDAO;
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/menu")
	public List<Menu> findAllMenu(){
		return menuDAO.findAllMenu();
	}
	
	

}
