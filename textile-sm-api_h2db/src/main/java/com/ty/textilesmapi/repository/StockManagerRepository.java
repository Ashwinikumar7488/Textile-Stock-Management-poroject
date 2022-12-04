package com.ty.textilesmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.textilesmapi.dto.StockManager;

public interface StockManagerRepository extends JpaRepository<StockManager, Integer> {
	public StockManager findByEmailAndPassword(String email, String password);
}
