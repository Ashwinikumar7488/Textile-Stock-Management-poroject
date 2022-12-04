package com.ty.textilesmapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.textilesmapi.dao.StockManagerDao;
import com.ty.textilesmapi.dto.Login;
import com.ty.textilesmapi.dto.Shop;
import com.ty.textilesmapi.dto.StockManager;
import com.ty.textilesmapi.exceptions.IdNotFoundException;
import com.ty.textilesmapi.exceptions.InvalidCredentialException;
import com.ty.textilesmapi.util.ResponseStructure;

@Service
public class StockManagerService {

	@Autowired
	StockManagerDao stockManagerDao;

	public ResponseEntity<ResponseStructure<StockManager>> saveStockManager(StockManager stockManager) {
		List<Shop> shops = stockManager.getShops();
		stockManager.setShops(shops);

		ResponseStructure<StockManager> responceStructure = new ResponseStructure<>();
		responceStructure.setStatus(HttpStatus.CREATED.value());
		responceStructure.setMessage("CREATED");
		responceStructure.setData(stockManagerDao.saveStockManager(stockManager));

		return new ResponseEntity<>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<StockManager>> getStockManager(int id) {
		Optional<StockManager> opt = stockManagerDao.getStockManagerById(id);
		if (opt.isPresent()) {
			ResponseStructure<StockManager> responceStructure = new ResponseStructure<>();
			responceStructure.setStatus(HttpStatus.FOUND.value());
			responceStructure.setMessage("Id Found");
			responceStructure.setData(opt.get());
			return new ResponseEntity<ResponseStructure<StockManager>>(responceStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Given ID " + id + " not found");
	}

	public ResponseEntity<ResponseStructure<List<StockManager>>> getAll() {
		ResponseStructure<List<StockManager>> responceStructure = new ResponseStructure<>();
		responceStructure.setStatus(HttpStatus.OK.value());
		responceStructure.setMessage("Success");
		responceStructure.setData(stockManagerDao.getAll());
		return new ResponseEntity<ResponseStructure<List<StockManager>>>(responceStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<StockManager>> deleteStockManager(int id) {
		Optional<StockManager> opt = stockManagerDao.getStockManagerById(id);
		if (opt.isPresent()) {
			stockManagerDao.deleteStockManager(id);
			ResponseStructure<StockManager> responseStructure = new ResponseStructure<StockManager>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED");
			responseStructure.setData(opt.get());
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given ID" + id + "not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<StockManager>> updateStockManager(int id, StockManager stockManager) {
		Optional<StockManager> opt = stockManagerDao.updateStockManager(id);
		if (opt.isPresent()) {
			StockManager sm = opt.get();
			sm.setName(stockManager.getName());
			sm.setEmail(stockManager.getEmail());
			sm.setPassword(stockManager.getPassword());
			ResponseStructure<StockManager> responceStructure = new ResponseStructure<>();
			responceStructure.setStatus(HttpStatus.OK.value());
			responceStructure.setMessage("Updated");
			responceStructure.setData(stockManagerDao.saveStockManager(sm));
			return new ResponseEntity<ResponseStructure<StockManager>>(responceStructure, HttpStatus.OK);
		} else
			throw new IdNotFoundException("Given ID" + id + "not found");
	}

	public ResponseEntity<ResponseStructure<StockManager>> validateStockManager(Login login) {
		StockManager stockManager = stockManagerDao.validateStockManager(login.getEmail(), login.getPassword());
		if (stockManager != null) {
			ResponseStructure<StockManager> responseStructure = new ResponseStructure<StockManager>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(stockManager);
			return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new InvalidCredentialException("Invalid credentails");
		}
	}

	
}
