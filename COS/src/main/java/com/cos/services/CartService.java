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
		cartRepository.save(cart);
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
		Calendar cal = Calendar.getInstance();
		Cart cart = null;
		if (cartRepository.findByUser(userId).size() == 0) {
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
		cart.setUserId(userId);
		selectedProducts.get(selectedProducts.size() - 1).setCart(cart);
		int totalPrice = calculateTotalPrice(selectedProducts);
		cart.setTotalPrice(String.valueOf(totalPrice));
		cart.setAddedDate(cal.getTime());
		cartRepository.save(cart);
		return cart;
	}
	
	@Override
	public int calculateTotalPrice(List<SelectedProduct> selectedProducts) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		for (int index = 0; index < selectedProducts.size(); index++) {
			if (selectedProducts.get(index).getCheckOut() == false) {
				int price = Integer.parseInt(selectedProducts.get(index).getProduct().getPrice());
				totalPrice += selectedProducts.get(index).getQuantity() * price;
			}
		}
		return totalPrice;
	}

	@Override
	public void checkOut(int userId, String note) {
		// TODO Auto-generated method stub
		List<Cart> listOfCartByUser = cartRepository.findByUser(userId);
		for (int index = 0; index < listOfCartByUser.size(); index++) {
			listOfCartByUser.get(index).setNote(note);
			listOfCartByUser.get(index).setCheckOut(true);
			for (SelectedProduct selected : listOfCartByUser.get(index).getSelectedproducts()) {
				selectedRepository.setCheckOutBySelectedId(selected.getSelectedId());
			}
		}	
	}

	@Override
	public List<Cart> getCheckOutCart() {
		// TODO Auto-generated method stub
		List<Cart> checkedOutCarts = cartRepository.getCheckOutCart();
		return checkedOutCarts;
	}

	@Override
	public Cart getCartDetail(int cartId) {
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findByCartId(cartId);
		return cart;
	} 
}
