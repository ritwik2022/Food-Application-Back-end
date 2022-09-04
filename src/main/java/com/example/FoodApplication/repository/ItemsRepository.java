package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
