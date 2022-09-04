package com.example.FoodApplication.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.BranchManager;
import com.example.FoodApplication.repository.BranchManagerRep;

@Repository
public class BranchManagerDAO 
{
	@Autowired
    BranchManagerRep branchManagerRep;
    
	//save
    public BranchManager saveBranchManager(BranchManager branchManager) {
    	return branchManagerRep.save(branchManager);
    }
    
 // update
 	public BranchManager updateBranchManager(BranchManager branchManager) {
 		return branchManagerRep.save(branchManager);

 	}

 	// delete
 	public BranchManager deletebranchManager(int id) {
 		BranchManager branchManager= getBranchManagerById(id).get();
 	    branchManagerRep.delete(branchManager);
 		return branchManager;
 	}
 	
   //getById
 	public Optional<BranchManager> getBranchManagerById(int id) {
 		return branchManagerRep.findById(id);
 	}
 	
   //find all Admins
 	public List<BranchManager> findAllBranchManagers(){
 		return branchManagerRep.findAll();
 	}

}
