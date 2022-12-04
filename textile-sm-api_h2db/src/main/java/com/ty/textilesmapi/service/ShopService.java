package com.ty.textilesmapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.textilesmapi.dao.ShopDao;
import com.ty.textilesmapi.dto.Shop;
import com.ty.textilesmapi.exceptions.IdNotFoundException;
import com.ty.textilesmapi.repository.ShopRepository;
import com.ty.textilesmapi.util.ResponseStructure;

@Service
public class ShopService {
	@Autowired
	private ShopDao dao;
	@Autowired
	private ShopRepository shoprepository;

	// Save Shop
	public ResponseEntity<ResponseStructure<Shop>> saveShop(Shop shop) {
		ResponseStructure<Shop> responseStructure = new ResponseStructure<Shop>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.saveShop(shop));
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	// Get Shop By Id
	public ResponseEntity<ResponseStructure<Shop>> getShopById(int Id) {
		Optional<Shop> opt = dao.getShopById(Id);
		ResponseStructure<Shop> responseStructure = new ResponseStructure<Shop>();
		if (opt.isPresent()) {
			Shop resShop = opt.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(resShop);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	// Get All Shop
	public ResponseEntity<ResponseStructure<List<Shop>>> getAllShop() {
		ResponseStructure<List<Shop>> responseStructure = new ResponseStructure<List<Shop>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(dao.getAllShop());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	// Update Shop
	public ResponseEntity<ResponseStructure<Shop>> updateShop(int id, Shop shop) {
		Optional<Shop> opt = dao.updateShop(id, shop);
		ResponseStructure<Shop> responseStructure = new ResponseStructure<Shop>();
		if (opt.isPresent()) {

			Shop resShop = opt.get();
			resShop.setName(shop.getName());
			resShop.setAddress(shop.getAddress());
			resShop.setLicense(shop.getLicense());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(dao.saveShop(resShop));
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	// DeleteShop
	public ResponseEntity<ResponseStructure<Shop>> deleteShop(int shopid) {
		Optional<Shop> opt = dao.deleteShop(shopid);
		ResponseStructure<Shop> responseStructure = new ResponseStructure<Shop>();
		if (opt.isPresent()) {
			Shop shop = opt.get();
			shoprepository.delete(shop);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("DELETED");

			responseStructure.setData(shop);
			return new ResponseEntity<ResponseStructure<Shop>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("NOT DELETED");
			return new ResponseEntity<ResponseStructure<Shop>>(responseStructure, HttpStatus.NOT_FOUND);
		}

	}

}
