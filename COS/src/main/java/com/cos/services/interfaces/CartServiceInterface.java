package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.Cart;
import com.cos.entities.SelectedProduct;

public interface CartServiceInterface {

	List<Cart> getAllCart();
	Cart createCart();
	
	Cart addSelectedProductToCart(int selectedId);
	Cart updateCart(int selectedId, int cartId);

	int calculateTotalPrice(List<SelectedProduct> selectedProducts);
	void checkOut(int userId, String note);
	//Only Admin can use this method
	List<Cart> getCheckOutCart();
	Cart getCartDetail(int cartId);
}
