package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>  {
	@Query("select c from Cart c where c.userId = :userId and c.checkOut = false")
	List<Cart> findByUser(@Param("userId") int userId);
	List<Cart> findAllByOrderByAddedDateDesc();
	@Query("select c from Cart c where c.checkOut = true")
	List<Cart> getCheckOutCart();
	Cart findByCartId(int cartId);
}
