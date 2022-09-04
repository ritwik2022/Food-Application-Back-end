package com.example.FoodApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApplication.ExceptionHandle.IdNotFoundException;
import com.example.FoodApplication.dao.BranchManagerDAO;
import com.example.FoodApplication.dto.BranchManager;
import com.example.FoodApplication.util.AES;
import com.example.FoodApplication.util.ResponseStructure;

@Service
public class BranchManagerService {
	@Autowired
	BranchManagerDAO branchManagerDAO;

	AES aes = new AES();

	public ResponseStructure<BranchManager> saveBranchManager(BranchManager branchManager) {
		String encrypt = aes.encrypt(branchManager.bpass, "Apple");
		branchManager.bpass = encrypt;

		ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
		structure.setMsg("Branch Manager Saved Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(branchManagerDAO.saveBranchManager(branchManager));
		return structure;

	}
	
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(int id) {
		Optional<BranchManager> optional = branchManagerDAO.getBranchManagerById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}

		else {
			ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
			structure.setMsg("Branch Manager Found Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
		}

	}
	
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(int id) {
		ResponseStructure<BranchManager> structure = new ResponseStructure<BranchManager>();
		structure.setMsg("Branch Manager Deleted Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDAO.deletebranchManager(id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<BranchManager>>> findAllBranchManagers() {
		ResponseStructure<List<BranchManager>> structure = new ResponseStructure<List<BranchManager>>();
		structure.setMsg("Branchmanager Found Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDAO.findAllBranchManagers());
		return new ResponseEntity<ResponseStructure<List<BranchManager>>>(structure, HttpStatus.OK);
	}

}
