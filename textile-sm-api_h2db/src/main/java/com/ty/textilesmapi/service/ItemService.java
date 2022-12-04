package com.ty.textilesmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.textilesmapi.dao.ItemDao;
import com.ty.textilesmapi.dto.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao dao;

	public Item raiseRequest(Item item) {
		item.setTotalCost(item.getPrice() * item.getQuantity());
		return dao.raiseRequest(item);
	}

	public List<Item> getRequest() {
		return dao.getRequest();
	}
}
