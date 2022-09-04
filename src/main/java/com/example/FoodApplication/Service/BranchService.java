package com.example.FoodApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApplication.ExceptionHandle.IdNotFoundException;
import com.example.FoodApplication.dao.BranchDAO;

import com.example.FoodApplication.dto.Branch;


import com.example.FoodApplication.util.ResponseStructure;

@Service
public class BranchService {
	
	@Autowired
	BranchDAO branchDAO;


  //Save
	public ResponseStructure<Branch> saveBranchManager(Branch branch) {
		

		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setMsg("Branch  Saved Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(branchDAO.saveBranch(branch));
		return structure;

	}
	
	//Get
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		Optional<Branch> optional = branchDAO.getBranchById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}

		else {
			ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
			structure.setMsg("Branch Manager Found Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
		}

	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {
		ResponseStructure<Branch> structure = new ResponseStructure<Branch>();
		structure.setMsg("Branch Deleted Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchDAO.deletebranch(id));
		return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> findAllBranch() {
		ResponseStructure<List<Branch>> structure = new ResponseStructure<List<Branch>>();
		structure.setMsg("Branch Found Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchDAO.findAllBranchs());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
	}

}
