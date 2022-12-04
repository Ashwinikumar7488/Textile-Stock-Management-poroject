package com.ty.textilesmapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.textilesmapi.dto.Admin;
import com.ty.textilesmapi.dto.Login;
import com.ty.textilesmapi.service.AdminService;
import com.ty.textilesmapi.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/admins")
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;

	@ApiOperation(value = "Save admin details", notes = "This API is to save  the admin details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@PostMapping()
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@ApiOperation(value = "Validate admin details", notes = "This API is to validate  the admin details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS"),
			@ApiResponse(code = 400, message = "bad request"), @ApiResponse(code = 401, message = "not authorized"),
			@ApiResponse(code = 403, message = "access forbidden"),
			@ApiResponse(code = 404, message = "given id not found"),
			@ApiResponse(code = 405, message = "method not supported") })
	@GetMapping()
	public ResponseEntity<ResponseStructure<Admin>> validateAdmin(@RequestBody Login login) {
		return adminService.validateAdmin(login);
	}
}