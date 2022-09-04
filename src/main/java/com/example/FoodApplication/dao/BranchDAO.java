package com.example.FoodApplication.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.Branch;
import com.example.FoodApplication.repository.BranchRepository;

@Repository
public class BranchDAO {

	@Autowired
	BranchRepository branchRepository;
	
	//save
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}
	
	// update
	public Branch updateBranch(Branch branch) {
		return branchRepository.save(branch);

	}

	// delete
	public Branch deletebranch(int id) {
		Branch branch= getBranchById(id).get();
	    branchRepository.delete(branch);
		return branch;
	}
	
  //getById
	public Optional<Branch>  getBranchById(int id) {
		return branchRepository.findById(id);
	}
	
  //find all Admins
	public List<Branch> findAllBranchs(){
		return branchRepository.findAll();
	}

}
