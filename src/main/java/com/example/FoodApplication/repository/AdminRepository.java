package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
