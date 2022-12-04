package com.ty.textilesmapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilesmapi.dto.Login;
import com.ty.textilesmapi.dto.StockManager;
import com.ty.textilesmapi.service.StockManagerService;
import com.ty.textilesmapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/stockmanagers")
@RestController
public class StockManagerController {

	@Autowired
	StockManagerService stockManagerService;
	
	@ApiOperation(value = "save StockManager", notes = "This API is to save the StockManager")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PostMapping()
	public ResponseEntity<ResponseStructure<StockManager>> saveStockManager(@Validated @RequestBody StockManager stockManager){
		return stockManagerService.saveStockManager(stockManager);
	}
	
	@ApiOperation(value = "Get StockManager", notes = "This API is to get the StockManager details by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<StockManager>> getStockManager(@PathVariable int id){
		return stockManagerService.getStockManager(id);
	}
	
	@ApiOperation(value = "Get All StockManager", notes = "This API is to get all the StockManager details ")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "FOUND"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping()
	public ResponseEntity<ResponseStructure<List<StockManager>>> getAll(){
		return stockManagerService.getAll();
	}
	
	@ApiOperation(value = "Delete StockManager ", notes = "This API is to delete the StockManager by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "DELETED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<StockManager>> deleteStockManager(@PathVariable int id){
		return stockManagerService.deleteStockManager(id);
	}
	
	@ApiOperation(value = "Update StockManager", notes = "This API is to update the StockManager details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UPDATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<StockManager>> updateStockManager(@PathVariable int id,@RequestBody StockManager stockManager){
		return stockManagerService.updateStockManager(id, stockManager);
	}
	
	@ApiOperation(value = "Validate StockManager", notes = "This API is to validate the StockManager details by id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UPDATED"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<StockManager>> validateStockManager(@RequestBody Login login){
		return stockManagerService.validateStockManager(login);
	}
	}
