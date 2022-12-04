package com.ty.textilesmapi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private String license;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items;

	@OneToOne(cascade = CascadeType.ALL)
	private ShopKeeper shopKeeper;
}
