package com.example.FoodApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FoodApplication.ExceptionHandle.IdNotFoundException;
import com.example.FoodApplication.dao.AdminDAO;
import com.example.FoodApplication.dto.Admin;

import com.example.FoodApplication.util.AES;
import com.example.FoodApplication.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDAO adminDAO;
	AES aes = new AES();

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		String encrypt = aes.encrypt(admin.apass, "Apple");
		admin.apass = encrypt;
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setMsg("Admin Saved Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(adminDAO.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		Optional<Admin> optional = adminDAO.getAdminById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException();
		}

		else {
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			structure.setMsg("Admin Found Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}

	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin1(int id) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setMsg("Admin Deleted Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(adminDAO.deleteAdmin(id));
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin() {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
		structure.setMsg("Admins Found Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(adminDAO.findAllAdmins());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.OK);
	}

}
