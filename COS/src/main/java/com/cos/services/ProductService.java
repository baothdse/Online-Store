package com.cos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Product;
import com.cos.repositories.ProductRepository;
import com.cos.services.interfaces.ProductServiceInterface;

@Service
@Transactional
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepository;
	
	List<Product> listOfProducts;
	
	@Override
	public Product getNewestProduct() {
		listOfProducts = productRepository.findAll();
		return listOfProducts.get(listOfProducts.size() - 1);
	}
	@Override
	public Product getBestSellingProduct() {
		Product product = new Product();
		listOfProducts = productRepository.findAll();
		int max = 0; 
		for (int index = 0; index < listOfProducts.size(); index++) {
			if (listOfProducts.get(index).getSoldQuantity() > max) {
				product = listOfProducts.get(index);
				max = listOfProducts.get(index).getSoldQuantity();
			}
		}
		return product;
	}
	@Override
	public List<Product> getRelatedProduct(String productKind) {
		listOfProducts = productRepository.findRelatedProduct(productKind, new PageRequest(0,6));
		return listOfProducts;
	}
	
}
