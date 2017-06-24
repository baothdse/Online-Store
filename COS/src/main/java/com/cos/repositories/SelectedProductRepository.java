package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.entities.Cart;
import com.cos.entities.SelectedProduct;

public interface SelectedProductRepository extends JpaRepository<SelectedProduct, Integer> {

	List<SelectedProduct> findByCart(int selectedId);
	
	SelectedProduct findBySelectedId(int selectedId);
}
