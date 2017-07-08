package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.entities.SelectedProduct;

public interface SelectedProductRepository extends JpaRepository<SelectedProduct, Integer> {

	List<SelectedProduct> findByCart(int selectedId);
	
	SelectedProduct findBySelectedId(int selectedId);
	
	@Modifying
	@Query("update SelectedProduct s set s.quantity = ?1 where s.selectedId = ?2")
	void updateQuantity(int quantity, int selectedId);
}
