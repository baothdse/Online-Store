package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>  {

//	List<Cart> findAllByOrderByAddedDateDesc();
	
	@Query("select c from Cart c where c.checkOut = true")
	List<Cart> getCheckOutCart();
	
	Cart findByCartId(int cartId);	
	
	@Modifying
	@Query("update Cart c set c.totalPrice = ?1 where c.cartId = ?2")
	void setTotalPriceByCartId(String totalPrice, int cartId);
}
