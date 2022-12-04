package com.ty.textilesmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.textilesmapi.dto.ShopKeeper;

public interface ShopKeeperRepository extends JpaRepository<ShopKeeper, Integer> {

	public ShopKeeper findByEmailAndPassword(String email, String password);
}