package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{

}
