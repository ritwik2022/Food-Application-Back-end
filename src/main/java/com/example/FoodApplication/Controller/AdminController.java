package com.example.FoodApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodApplication.Service.AdminService;
import com.example.FoodApplication.dao.AdminDAO;
import com.example.FoodApplication.dto.Admin;
import com.example.FoodApplication.util.ResponseStructure;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class AdminController {

	@Autowired
	AdminDAO adminDAO;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<Admin>>  saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@DeleteMapping("/deleteadmin")
	public ResponseEntity<ResponseStructure<Admin>>    deleteAdmin(@RequestParam int id) {
		return adminService.deleteAdmin1(id);
	}
	
	@GetMapping("/getbyidadmin/{id}")
	public ResponseEntity<ResponseStructure<Admin>>  getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}
	
	@GetMapping("/alladmin")
	public ResponseEntity<ResponseStructure<List<Admin>>>  findAllAdmins(){
		return adminService.findAllAdmin();
	}
}
