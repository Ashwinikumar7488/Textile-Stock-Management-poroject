package com.ty.textilesmapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilesmapi.dto.StockManager;
import com.ty.textilesmapi.repository.StockManagerRepository;

@Repository
public class StockManagerDao {

	@Autowired
	StockManagerRepository stockManagerRepository;
	
	public StockManager saveStockManager(StockManager stockManager) {
		return stockManagerRepository.save(stockManager);
	}
	
	public Optional<StockManager> getStockManagerById(int id) {
		return stockManagerRepository.findById(id);
	}
	
	public List<StockManager> getAll() {
		return stockManagerRepository.findAll();
	}
	
	public void deleteStockManager(int id) {
		stockManagerRepository.deleteById(id);
	}
	
	public Optional<StockManager> updateStockManager(int id) {
		return stockManagerRepository.findById(id);
	}
	
	public StockManager validateStockManager(String email,String password) {
		return stockManagerRepository.findByEmailAndPassword(email, password);
	}
}
