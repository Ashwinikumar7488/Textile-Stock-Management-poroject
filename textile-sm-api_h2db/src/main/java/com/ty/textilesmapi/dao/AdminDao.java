package com.ty.textilesmapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.textilesmapi.dto.Admin;
import com.ty.textilesmapi.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin validateAdmin(String email, String password) {
		return adminRepository.findByEmailAndPassword(email, password);
	}
}