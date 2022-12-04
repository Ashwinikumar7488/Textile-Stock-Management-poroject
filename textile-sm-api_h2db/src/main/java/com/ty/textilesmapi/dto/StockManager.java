package com.ty.textilesmapi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class StockManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	@Column(unique = false)
	private String email;
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Shop> shops;
}
