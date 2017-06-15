package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.entities.Cart;
import com.cos.entities.SelectedProduct;

public interface SelectedProductRepository extends JpaRepository<SelectedProduct, Integer> {
	
	@Query("select sp from SelectedProduct sp where sp.user.userId = :userId and sp.checkOut = false")
	List<SelectedProduct> findByUserId(@Param("userId") int userId);
	
	@Modifying
	@Query("update SelectedProduct sp set sp.checkOut = true where sp.checkOut = false "
			+ "and sp.selectedId = :selectedId")
	void setCheckOutBySelectedId(@Param("selectedId") int selectedId);
	
	List<SelectedProduct> findByCart(int selectedId);
	
	@Modifying
	@Query("update SelectedProduct sp set sp.cart = ?1 where sp.user.userId = ?2 and "
			+ "sp.checkOut = false")
	List<SelectedProduct> setCartForSelectedProduct(Cart cart, int userId);
	
	SelectedProduct findBySelectedId(int selectedId);
}
