package com.example.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.FoodApplication.dto.Admin;
import com.example.FoodApplication.repository.AdminRepository;

@Repository
public class AdminDAO {
	@Autowired
	AdminRepository adminRepository;

	// save
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	// update
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);

	}

	// delete
	public Admin deleteAdmin(int id) {
		Admin admin = getAdminById(id).get();
		adminRepository.delete(admin);
		return admin;
	}
	
  //getById
	public Optional<Admin> getAdminById(int id) {
		return adminRepository.findById(id);
	}
	
  //find all Admin
	public List<Admin> findAllAdmins(){
		return adminRepository.findAll();
	}
	

}
