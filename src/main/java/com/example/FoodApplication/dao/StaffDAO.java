package com.example.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.Staff;
import com.example.FoodApplication.repository.StaffRepository;

@Repository
public class StaffDAO {
	
	@Autowired
	StaffRepository staffRep;
	
	//save
	public Staff saveStaff(Staff staff) {
		return staffRep.save(staff);
	}

	// update
		public Staff updateStaff(Staff staff) {
			return staffRep.save(staff);

		}

		// delete
		public Staff deleteStaff(int id) {
			Staff staff = getStaffById(id).get();
			staffRep.delete(staff);
			return staff;
		}

		// getById
		public Optional<Staff> getStaffById(int id) {
			return staffRep.findById(id);
		}

		// find all A
		public List<Staff> findAllStaffs() {
			return staffRep.findAll();
		}

}
