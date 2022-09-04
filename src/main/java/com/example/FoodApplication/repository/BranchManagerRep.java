package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.BranchManager;

public interface BranchManagerRep extends JpaRepository<BranchManager, Integer>{

}
