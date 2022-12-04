package com.ty.textilesmapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.textilesmapi.controller.ItemController;
import com.ty.textilesmapi.dao.ShopKeeperDao;
import com.ty.textilesmapi.dto.Item;
import com.ty.textilesmapi.dto.Login;
import com.ty.textilesmapi.dto.ShopKeeper;
import com.ty.textilesmapi.exceptions.IdNotFoundException;
import com.ty.textilesmapi.repository.ShopKeeperRepository;
import com.ty.textilesmapi.util.ResponseStructure;

@Service
public class ShopKeeperService {

	@Autowired
	private ShopKeeperDao shopKeeperDao;

	@Autowired
	private ShopKeeperRepository shopKeeperRepository;

	@Autowired
	ShopKeeper keeper;

	@Autowired
	ItemController controller;

	public ResponseEntity<ResponseStructure<ShopKeeper>> saveShopKeeper(ShopKeeper shopkeeper) {
		ResponseStructure<ShopKeeper> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("CREATED SUCCESSFULLY");
		ShopKeeper shopKeeper = shopKeeperDao.saveShopKeeper(shopkeeper);
		responseStructure.setData(shopKeeper);
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<ShopKeeper>> getShopKeeper(int id) {
		ResponseStructure<ShopKeeper> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		Optional<ShopKeeper> opt = shopKeeperDao.getShopKeeperById(id);
		if (opt.isPresent()) {
			ShopKeeper shopkeeper = (ShopKeeper) opt.get();
			responseStructure.setData(shopkeeper);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given id " + id + " not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<ShopKeeper>>> getAllShopKeeper() {
		ResponseStructure<List<ShopKeeper>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(shopKeeperDao.getAllShopKeeper());
		return new ResponseEntity<ResponseStructure<List<ShopKeeper>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<ShopKeeper>> updateShopKeeper(int id, ShopKeeper shopkeeper) {
		Optional<ShopKeeper> optional = shopKeeperDao.updateShopKeeper(id, shopkeeper);
		ResponseStructure<ShopKeeper> responseStructure = new ResponseStructure<>();

		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			ShopKeeper keeper = optional.get();
			keeper.setId(shopkeeper.getId());
			keeper.setName(shopkeeper.getName());
			keeper.setEmail(shopkeeper.getEmail());
			keeper.setPassword(shopkeeper.getPassword());
			keeper.setPhone(shopkeeper.getPhone());
			responseStructure.setData(shopKeeperDao.saveShopKeeper(keeper));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given id" + id + ", does not exist");
		}
	}

	public ResponseEntity<ResponseStructure<ShopKeeper>> deleteShopKeeper(int id) {
		Optional<ShopKeeper> optional = shopKeeperDao.deleteShopKeeper(id);
		ResponseStructure<ShopKeeper> responseStructure = new ResponseStructure<>();

		if (optional.isPresent()) {
			ShopKeeper shopkeeper = optional.get();
			shopKeeperRepository.delete(shopkeeper);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESSFULLY DELETED");
			responseStructure.setData(shopkeeper);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Given id" + id + ", does not exist");
		}
	}

	public ResponseEntity<ResponseStructure<ShopKeeper>> validateUser(Login login) {
		ResponseStructure<ShopKeeper> responseStructure = new ResponseStructure<>();
		ShopKeeper shopkeeper = shopKeeperDao.validateShopKeeper(login.getEmail(), login.getPassword());
		if (shopkeeper != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			if (keeper.getSk_stock() < 25) {
				Item item = new Item();
				controller.raiseRequest(item);
			} else {
				System.out.println("stock is sufficient");
			}
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Invalid credentials");
		}
		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

//	public ResponseStructure<ShopKeeper> getStock(Item item) {
//
//		keeper.setSk_stock(keeper.getSk_stock() - item.getQuantity());
//		ResponseStructure responseStructure = new ResponseStructure<>();
//
//		
//		responseStructure.setData(item);
//
//		return responseStructure;
//
//	}

}
