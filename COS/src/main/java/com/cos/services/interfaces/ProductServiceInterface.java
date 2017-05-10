package com.cos.services.interfaces;

import java.util.Date;
import java.util.List;

import com.cos.entities.Product;

public interface ProductServiceInterface {
	Product getNewestProduct ();
	Product getBestSellingProduct();
	List<Product> getRelatedProduct(String productKind);
	Product getProductById(Integer productId);
	Product getProductDetail(Integer productId);
	Product createProduct(String productName, String introduction, String productKind, String brand, 
			String price, int productQuantity);
	void deleteProductById(int productId);
	List<Product> get4ProductByProductKind(String productKind);
	List<Product> getAllProduct();
	void updateProductInfo(String introduction, String productKind, String brand, 
			String price, int productQuantity, Date addedDate, Date addedTime, int productId);
}
