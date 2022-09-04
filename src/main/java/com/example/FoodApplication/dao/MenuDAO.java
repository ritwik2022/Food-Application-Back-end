package com.example.FoodApplication.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.Menu;
import com.example.FoodApplication.repository.MenuRepository;

@Repository
public class MenuDAO {
	@Autowired
	MenuRepository menuRep;
	
	//all
	public List<Menu> findAllMenu(){
		return menuRep.findAll();
	}
	
}
