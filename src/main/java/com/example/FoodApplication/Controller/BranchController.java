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

import com.example.FoodApplication.Service.BranchService;
import com.example.FoodApplication.dao.BranchDAO;

import com.example.FoodApplication.dto.Branch;
import com.example.FoodApplication.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BranchController {
	@Autowired
	BranchDAO branchDAO;
	
	@Autowired
	BranchService branchService;
	
	@PostMapping("/savebranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranchManager(branch);
	}
    
    @DeleteMapping("/deletebranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}
	
	@GetMapping("/getbyidbranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}
	
	@GetMapping("/findallbranch")
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranchs(){
		return branchService.findAllBranch();
	}

}
