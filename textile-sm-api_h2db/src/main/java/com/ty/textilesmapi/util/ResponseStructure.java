package com.ty.textilesmapi.util;

import java.util.List;

import com.ty.textilesmapi.dto.ShopKeeper;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;

}
