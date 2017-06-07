package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.Cart;
import com.cos.entities.SelectedProduct;

public interface CartServiceInterface {

	List<Cart> getAllCart();
	Cart createCart();
	List<Cart> getCartByUserId(int userId);
	Cart addSelectedProductToCart(int userId);
	int calculateTotalPrice(List<SelectedProduct> selectedProducts);
	void checkOut(int userId, String note);
	List<Cart> getCheckOutCart();
	Cart getCartDetail(int cartId);
}
