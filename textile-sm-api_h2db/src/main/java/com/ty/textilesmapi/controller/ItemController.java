package com.ty.textilesmapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilesmapi.dto.Item;
import com.ty.textilesmapi.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/raiserequest")
	public Item raiseRequest(@RequestBody Item item) {
		return itemService.raiseRequest(item);
	}

	@GetMapping("/getrequest")
	public List<Item> getRequest() {
		return itemService.getRequest();
	}
}
