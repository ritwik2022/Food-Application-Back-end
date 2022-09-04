package com.example.FoodApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodApplication.dao.StaffDAO;
import com.example.FoodApplication.dto.Staff;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StaffController {
	
	@Autowired
	StaffDAO staffDAO;
	
	public Staff saveStaff(@RequestBody Staff staff) {
		return staffDAO.saveStaff(staff);
	}

}
