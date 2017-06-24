package com.cos.services.interfaces;

import com.cos.entities.Cart;
import com.cos.entities.SelectedProduct;

public interface SelectedProductServiceInterface {
	SelectedProduct selectProduct(int productId, int quantity);
	void removeProductFromCart(int selectedId, int cartId);
	int recountPrice(Cart cart);
	SelectedProduct getSelectedById(int selectedId);
}
