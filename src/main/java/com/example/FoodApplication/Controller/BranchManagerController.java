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

import com.example.FoodApplication.Service.BranchManagerService;
import com.example.FoodApplication.dao.BranchManagerDAO;

import com.example.FoodApplication.dto.BranchManager;
import com.example.FoodApplication.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BranchManagerController {

	@Autowired
	BranchManagerDAO branchManagerDAO;
	
	@Autowired
	BranchManagerService branchManagerService;
	
	
	@PostMapping("/savebm")
	public ResponseStructure<BranchManager> saveBranchManager(@RequestBody BranchManager branchManager) {
		return branchManagerService.saveBranchManager(branchManager);
	}

	@DeleteMapping("/deletebm")
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(@RequestParam int id) {
		return branchManagerService.deleteBranchManager(id);
	}

	@GetMapping("/getbyidbm/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(@PathVariable int id) {
		return branchManagerService.getBranchManagerById(id);
	}

	@GetMapping("/allbm")
	public ResponseEntity<ResponseStructure<List<BranchManager>>>  findAllBranchManagers() {
		return branchManagerService.findAllBranchManagers();
	}

}
