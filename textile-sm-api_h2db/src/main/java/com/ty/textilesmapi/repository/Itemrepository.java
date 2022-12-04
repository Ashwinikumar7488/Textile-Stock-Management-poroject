package com.ty.textilesmapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.textilesmapi.dto.Item;

public interface Itemrepository extends JpaRepository<Item, Integer> {

}
