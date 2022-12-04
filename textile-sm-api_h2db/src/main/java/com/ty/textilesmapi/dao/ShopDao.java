package com.ty.textilesmapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilesmapi.dto.Shop;
import com.ty.textilesmapi.repository.ShopRepository;

@Repository
public class ShopDao {
	@Autowired
	ShopRepository shoprepository;

	// Save Shop
	public Shop saveShop(Shop shop) {
		return shoprepository.save(shop);
	}

	// Get Shop by ID
	public Optional<Shop> getShopById(int shopId) {
		return shoprepository.findById(shopId);
	}

	// Get Shop List
	public List<Shop> getAllShop() {
		return shoprepository.findAll();
	}

	// Update Shop
	public Optional<Shop> updateShop(int shopId, Shop shop) {
		return shoprepository.findById(shopId);

	}

	// Delete Shop
	public Optional<Shop> deleteShop(int shopId) {
		return shoprepository.findById(shopId);
	}

}
