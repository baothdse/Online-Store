package com.cos.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Cart;
import com.cos.entities.SelectedProduct;
import com.cos.repositories.CartRepository;
import com.cos.repositories.SelectedProductRepository;
import com.cos.services.interfaces.CartServiceInterface;

@Service
@Transactional
public class CartService implements CartServiceInterface {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private SelectedProductRepository selectedRepository;
	
	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public Cart createCart() {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		return cart;
	}

	@Override
	public List<Cart> getCartByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Cart> cart = cartRepository.findByUser(userId);
		return cart;
	}

	@Override
	public Cart addSelectedProductToCart(int userId) {
		// TODO Auto-generated method stub
		List<SelectedProduct> selectedProducts = selectedRepository.findByUserId(userId); 
		List<Cart> listOfCartByUser = cartRepository.findByUser(userId);
		Cart cart = new Cart();
		if (cartRepository.findByUser(userId) == null) {
			cart = createCart();
		} else {
			for (int index = 0; index < listOfCartByUser.size(); index++) {
				if (listOfCartByUser.get(index).getCheckOut() == false) {
					cart = listOfCartByUser.get(index);
				} else {
					cart = createCart();
				}
			}
		}
		Calendar cal = Calendar.getInstance();
		int totalPrice = 0;
		cart.setUserId(userId);
		cart.setSelectedproducts(selectedProducts);
		
		for (int index = 0; index < selectedProducts.size(); index++) {
			if (selectedProducts.get(index).getCheckOut() == false) {
				int price = Integer.parseInt(selectedProducts.get(index).getProduct().getPrice());
				totalPrice += selectedProducts.get(index).getQuantity() * price;
				cart.setTotalPrice(String.valueOf(totalPrice));
			}
		}
		cart.setAddedDate(cal.getTime());
		cartRepository.save(cart);
		return cart;
	}
 
}
