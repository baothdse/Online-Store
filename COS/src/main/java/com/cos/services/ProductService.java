package com.cos.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Image;
import com.cos.entities.Product;
import com.cos.repositories.ImageRepository;
import com.cos.repositories.ProductRepository;
import com.cos.services.interfaces.ProductServiceInterface;

@Service
@Transactional
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getNewestProduct() {
		List<Product> listOfProducts = productRepository.findAll();
		return listOfProducts.get(listOfProducts.size() - 1);
	}
	@Override
	public Product getBestSellingProduct() {
		Product product = new Product();
		List<Product> listOfProducts = productRepository.findAll();
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
		List<Product> listOfProducts = productRepository.findByProductKind(productKind, new PageRequest(0,5));
		return listOfProducts;
	}
	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		Product product = productRepository.findByProductId(productId);
		Image image = new Image();
		image.setProduct(product);
		product.getImages().add(image);
		return product;
	}
	@Override
	public Product createProduct(String productName, String introduction, String productKind, String brand,
			String price, int productQuantity) {
		// TODO Auto-generated method stub
		Product product = new Product();
		Calendar cal = Calendar.getInstance();
		if (productRepository.findByProductName(productName) == null) {
			product.setProductName(productName);
			product.setIntroduction(introduction);
			product.setProductKind(productKind);
			product.setBrand(brand);
			product.setPrice(price);
			product.setProductQuantity(productQuantity);
			product.setAddedDate(cal.getTime());
			product.setAddedTime(cal.getTime());
			product.setSoldQuantity(0);
			productRepository.save(product);
			return product;
		} else {
			return null;
		}
		
	}
	@Override
	public List<Product> get4ProductByProductKind(String productKind) {
		// TODO Auto-generated method stub
		List<Product> listOfProducts = productRepository.findByProductKind(productKind, new PageRequest(0,4));
		return listOfProducts;
	}
	
}
