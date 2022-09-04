package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

}
