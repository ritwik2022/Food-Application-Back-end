package com.example.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.FoodApplication.dto.Items;
import com.example.FoodApplication.repository.ItemsRepository;

@Repository
public class ItemsDAO {

	@Autowired
	ItemsRepository itemsRep;

	// save
	public Items saveItem(Items items) {
		return itemsRep.save(items);
	}

	// update
	public Items updateItems(Items items) {
		return itemsRep.save(items);

	}

	// delete
	public Items deleteItems(int id) {
		Items items = getItemsById(id).get();
		itemsRep.delete(items);
		return items;
	}

	// getById
	public Optional<Items> getItemsById(int id) {
		return itemsRep.findById(id);
	}

	// find all Admins
	public List<Items> findAllItems() {
		return itemsRep.findAll();
	}

}
