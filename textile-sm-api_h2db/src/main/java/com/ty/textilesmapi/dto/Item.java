package com.ty.textilesmapi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Entity
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int quantity;
	private double price;
	private double totalCost;
}
