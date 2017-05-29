package com.cos.services.interfaces;

import com.cos.entities.SelectedProduct;

public interface SelectedProductServiceInterface {
	SelectedProduct selectProduct(int userId, int productId, int quantity);
}
