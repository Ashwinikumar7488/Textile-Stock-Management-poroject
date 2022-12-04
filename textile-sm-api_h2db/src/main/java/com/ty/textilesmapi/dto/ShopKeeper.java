package com.ty.textilesmapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class ShopKeeper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	private long phone;
	private int sk_stock = 20;
}
