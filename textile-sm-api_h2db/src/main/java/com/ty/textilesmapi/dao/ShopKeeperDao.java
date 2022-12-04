package com.ty.textilesmapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilesmapi.dto.Item;
import com.ty.textilesmapi.dto.ShopKeeper;
import com.ty.textilesmapi.repository.ShopKeeperRepository;

@Repository
public class ShopKeeperDao {

	@Autowired
	ShopKeeperRepository shopkeeperRepository;

	public ShopKeeper saveShopKeeper(ShopKeeper shopkeeper) {
		return shopkeeperRepository.save(shopkeeper);
	}

	public Optional<ShopKeeper> getShopKeeperById(int id) {
		return shopkeeperRepository.findById(id);
	}

	public List<ShopKeeper> getAllShopKeeper() {
		return shopkeeperRepository.findAll();
	}

	public Optional<ShopKeeper> updateShopKeeper(int id, ShopKeeper shopkeeper) {
		return shopkeeperRepository.findById(id);
	}

	public Optional<ShopKeeper> deleteShopKeeper(int id) {
		return shopkeeperRepository.findById(id);
	}

	public ShopKeeper validateShopKeeper(String email, String password) {
		return shopkeeperRepository.findByEmailAndPassword(email, password);
	}

}
