package com.ty.textilesmapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilesmapi.dto.Login;
import com.ty.textilesmapi.dto.ShopKeeper;
import com.ty.textilesmapi.service.ItemService;
import com.ty.textilesmapi.service.ShopKeeperService;
import com.ty.textilesmapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/shopkeepers")
public class ShopKeeperController {

	@Autowired
	private ShopKeeperService keeperService;

	@Autowired
	ItemService itemService;

	@PostMapping()
	@ApiOperation(value = "saveShopkeeper", notes = "this method saves the details of the shopkeeper")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"), @ApiResponse(code = 405, message = "METHOD NOT FOUND") })
	public ResponseEntity<ResponseStructure<ShopKeeper>> saveShopKeeper(@RequestBody ShopKeeper keeper) {
		return keeperService.saveShopKeeper(keeper);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "getshopkeeper", notes = "this method fetch the details of the shopkeeper")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"), @ApiResponse(code = 405, message = "METHOD NOT FOUND") })
	public ResponseEntity<ResponseStructure<ShopKeeper>> getShopkeeper(@PathVariable int id) {
		return keeperService.getShopKeeper(id);
	}

	@GetMapping()
	@ApiOperation(value = "getallshopkeeper", notes = "this method fetch the details all the shopkeepers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"), @ApiResponse(code = 405, message = "METHOD NOT FOUND") })
	public ResponseEntity<ResponseStructure<List<ShopKeeper>>> getAllShopKeeper() {
		return keeperService.getAllShopKeeper();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "updateshopkeeper", notes = "this method update the details of the given shopkeeper")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"), @ApiResponse(code = 405, message = "METHOD NOT FOUND") })
	public ResponseEntity<ResponseStructure<ShopKeeper>> updateShopKeeper(@PathVariable int id,
			@RequestBody ShopKeeper keeper) {
		return keeperService.updateShopKeeper(id, keeper);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "deleteshopkeeper", notes = "this method delete the details of the given shopkeeper")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "BAD REQUEST"), @ApiResponse(code = 403, message = "FORBIDDEN"),
			@ApiResponse(code = 404, message = "NOT FOUND"), @ApiResponse(code = 405, message = "METHOD NOT FOUND") })
	public ResponseEntity<ResponseStructure<ShopKeeper>> deleteShopKeeper(@PathVariable int id) {
		return keeperService.deleteShopKeeper(id);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<ResponseStructure<ShopKeeper>> validateShopKeeper(@RequestBody Login login) {
		return keeperService.validateUser(login);
	}
}
