package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.FoodProduct;

public interface FoodProductRepository extends JpaRepository<FoodProduct, Integer> {

}
