package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch,Integer>{

}
