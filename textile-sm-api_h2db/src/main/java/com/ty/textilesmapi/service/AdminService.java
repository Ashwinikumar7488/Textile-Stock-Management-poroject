package com.ty.textilesmapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.textilesmapi.dao.AdminDao;
import com.ty.textilesmapi.dto.Admin;
import com.ty.textilesmapi.dto.Login;
import com.ty.textilesmapi.exceptions.InvalidCredentialException;
import com.ty.textilesmapi.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		Admin admin1 = adminDao.saveAdmin(admin);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(admin1);
		return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admin>> validateAdmin(Login login) {
		Admin admin = adminDao.validateAdmin(login.getEmail(), login.getPassword());
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (admin != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(admin);
			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new InvalidCredentialException();
		}
	}
}
