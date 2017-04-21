package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.Product;

public interface ProductServiceInterface {
	Product getNewestProduct ();
	Product getBestSellingProduct();
	List<Product> getRelatedProduct(String productKind);
	Product getProductById(Integer productId);
	Product createProduct(String productName, String introduction, String productKind, String brand, 
			String price, int productQuantity);
	List<Product> get4ProductByProductKind(String productKind);
}
