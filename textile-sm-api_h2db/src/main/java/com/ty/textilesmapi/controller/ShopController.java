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

import com.ty.textilesmapi.dto.Shop;
import com.ty.textilesmapi.service.ShopService;
import com.ty.textilesmapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/shops")
@RestController
public class ShopController {
		@Autowired
		private ShopService shopService;
		
		@ApiOperation(value = "Post all Valet Transactions", notes = "Save Shop with Shop ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "SAVED"),
				@ApiResponse(code = 400, message = "BAD REQUEST"),
				@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
				@ApiResponse(code = 404, message = "GIVEN ID NOT FOUND"),
				@ApiResponse(code = 405, message = "PATH NOT SUPPORTED") })
		@PostMapping()
		public ResponseEntity<ResponseStructure<Shop>> saveShop(@RequestBody Shop shop) {
			return shopService.saveShop(shop);
		}

		@ApiOperation(value = "Put all Valet Transactions", notes = "Update Shop with Shop Id")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "UPDATED"),
				@ApiResponse(code = 400, message = "BAD REQUEST"),
				@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
				@ApiResponse(code = 404, message = "GIVEN ID NOT FOUND"),
				@ApiResponse(code = 405, message = "PATH NOT SUPPORTED") })
		@PutMapping("/{shopId}")
		public ResponseEntity<ResponseStructure<Shop>> updateShop(@PathVariable int shopId,
				@RequestBody Shop shop) {
			return shopService.updateShop(shopId, shop);
		}

		@ApiOperation(value = "Delete all Valet Transactions", notes = "Delete Shop with Shop Id")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "DELETED"),
				@ApiResponse(code = 400, message = "BAD REQUEST"),
				@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
				@ApiResponse(code = 404, message = "GIVEN ID NOT FOUND"),
				@ApiResponse(code = 405, message = "PATH NOT SUPPORTED") })
		@DeleteMapping("/{shopId}")
		public ResponseEntity<ResponseStructure<Shop>> deleteShop(@PathVariable int shopId) {
			return shopService.deleteShop(shopId);
		}

		@ApiOperation(value = "Get all Valet Transactions", notes = "Get List of shops")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL"),
				@ApiResponse(code = 400, message = "BAD REQUEST"),
				@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
				@ApiResponse(code = 404, message = "GIVEN ID NOT FOUND"),
				@ApiResponse(code = 405, message = "PATH NOT SUPPORTED") })
		@GetMapping()
		public ResponseEntity<ResponseStructure<List<Shop>>> getAllShop() {
			return shopService.getAllShop();
		}
		
		@ApiOperation(value = "Get all Valet Transactions", notes = "Get Shop details with Shop ID")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESSFUL"),
				@ApiResponse(code = 400, message = "BAD REQUEST"),
				@ApiResponse(code = 403, message = "ACCESS FORBIDDEN"),
				@ApiResponse(code = 404, message = "GIVEN ID NOT FOUND"),
				@ApiResponse(code = 405, message = "PATH NOT SUPPORTED") })
		@GetMapping("/{shopId}")
		public ResponseEntity<ResponseStructure<Shop>> getShopById(@PathVariable int shopId) {
			return shopService.getShopById(shopId);
		}
		
		
		

}
