package com.cos.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cos.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>  {

//	List<Cart> findAllByOrderByAddedDateDesc();
	
	@Query("select c from Cart c where c.checkOut = true order by c.addedDate asc, c.addedTime asc")
	List<Cart> getCheckOutCart();
	
	Cart findByCartId(int cartId);	
	
	@Modifying
	@Query("update Cart c set c.totalPrice = ?1 where c.cartId = ?2")
	void setTotalPriceByCartId(String totalPrice, int cartId);
	
	@Modifying
	@Query("update Cart c set c.checkOut = ?1, c.fullName = ?2, c.address = ?3, c.city = ?4, c.email = ?5, "
			+ "c.phone = ?6, c.addedDate = ?7, c.addedTime = ?8 where c.cartId = ?9")
	void setCartDetail(boolean checkOut, String fullName, String address, String city, String email, 
			String phone, Date addedDate, Date addedTime, int cartId);
}
