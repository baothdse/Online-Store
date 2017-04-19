package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.Product;

public interface ProductServiceInterface {
	Product getNewestProduct ();
	Product getBestSellingProduct();
	List<Product> getRelatedProduct(String productKind);
}
