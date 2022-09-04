package com.example.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApplication.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
