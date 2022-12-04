package com.ty.textilesmapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilesmapi.dto.Item;
import com.ty.textilesmapi.repository.Itemrepository;

@Repository
public class ItemDao {

	@Autowired
	Itemrepository itemrepository;

	public Item raiseRequest(Item item) {
		return itemrepository.save(item);
	}

	public List<Item> getRequest() {
		return itemrepository.findAll();
	}
}
