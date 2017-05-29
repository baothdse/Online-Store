package com.cos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Product;
import com.cos.entities.SelectedProduct;
import com.cos.entities.User;
import com.cos.repositories.ProductRepository;
import com.cos.repositories.SelectedProductRepository;
import com.cos.repositories.UserRepository;
import com.cos.services.interfaces.SelectedProductServiceInterface;

@Service
@Transactional
public class SelectedProductService implements SelectedProductServiceInterface {

	@Autowired
	private SelectedProductRepository selectedProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public SelectedProduct selectProduct(int userId, int productId, int quantity) {
		// TODO Auto-generated method stub
		SelectedProduct selectedProduct = new SelectedProduct();
		Product product = productRepository.findByProductId(productId);
		User user = userRepository.findByUserId(userId);
		
		selectedProduct.setProduct(product);
		selectedProduct.setQuantity(quantity);
		selectedProduct.setUser(user);
		selectedProductRepository.save(selectedProduct);
		return selectedProduct;
	
	}

}
