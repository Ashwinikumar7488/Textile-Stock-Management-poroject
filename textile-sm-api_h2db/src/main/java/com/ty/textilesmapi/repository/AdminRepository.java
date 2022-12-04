package com.ty.textilesmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.textilesmapi.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

	public Admin findByEmailAndPassword(String email, String password);
}
