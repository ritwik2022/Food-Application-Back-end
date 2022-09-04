package com.example.FoodApplication.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.Customer;
import com.example.FoodApplication.repository.CustomerRepository;

@Repository
public class CustomerDAO 
{
	@Autowired
	CustomerRepository customerRep;
	
	//save
	public Customer saveCustomer(Customer customer) {
		return customerRep.save(customer);
	}
	
	
}
