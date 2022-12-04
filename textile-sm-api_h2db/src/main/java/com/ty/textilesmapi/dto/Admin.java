package com.ty.textilesmapi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel
@Component
@Data
@Entity
public class Admin {

	@NotNull
	@Id
	private String email;
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<StockManager> stockManagers;
}