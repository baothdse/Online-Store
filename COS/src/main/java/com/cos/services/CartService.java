package com.cos.services;

import java.util.Calendar;
import java.util.Date;
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
	public Cart addSelectedProductToCart(int selectedId) {
		// TODO Auto-generated method stub
		SelectedProduct selected = selectedRepository.findBySelectedId(selectedId);
		Cart cart = new Cart();
		selected.setCart(cart);
		cart.getSelectedproducts().add(selected);
		int totalPrice = Integer.parseInt(selected.getProduct().getPrice()) * selected.getQuantity();
		cart.setTotalPrice(String.valueOf(totalPrice));
		cartRepository.save(cart);
		return cart;
	}

	@Override
	public Cart updateCart(SelectedProduct selected, int cartId) {
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findByCartId(cartId);
		selected.setCart(cart);
		boolean flag = false;

		List<SelectedProduct> productInCart = cart.getSelectedproducts();
		for (int index = 0; index < productInCart.size(); index++) {
			if (selected.getProduct().getProductId().equals(productInCart.get(index).getProduct().getProductId())) {
				flag = true;
				int newQuantity = selected.getQuantity() + productInCart.get(index).getQuantity();
				int totalPrice = Integer.parseInt(cart.getTotalPrice()) + 
						(selected.getQuantity()* Integer.parseInt(selected.getProduct().getPrice()));					 
				selectedRepository.updateQuantity(newQuantity, productInCart.get(index).getSelectedId());
				
				cartRepository.setTotalPriceByCartId(String.valueOf(totalPrice), cartId);
				cart.getSelectedproducts().get(index).setQuantity(newQuantity);
				cart.setTotalPrice(String.valueOf(totalPrice));
				break;
			} else {flag = false;}
		}
		if (flag == false) {
			selectedRepository.save(selected);
			cart.getSelectedproducts().add(selected);
			int totalPrice = calculateTotalPrice(cart.getSelectedproducts());
			cartRepository.setTotalPriceByCartId(String.valueOf(totalPrice), cartId);
			cart.setTotalPrice(String.valueOf(totalPrice));
		}
		return cart;
	}

	@Override
	public int calculateTotalPrice(List<SelectedProduct> selectedProducts) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		for (int index = 0; index < selectedProducts.size(); index++) {
			int price = Integer.parseInt(selectedProducts.get(index).getProduct().getPrice());
			if (selectedProducts.get(index).getProduct().getDiscount() != null) {
				int priceAfterDiscount = price
						- (price * selectedProducts.get(index).getProduct().getDiscount().getAmount()) / 100;
				totalPrice += selectedProducts.get(index).getQuantity() * priceAfterDiscount;
			} else {
				totalPrice += selectedProducts.get(index).getQuantity() * price;
			}
		}
		return totalPrice;
	}

	@Override
	public void checkOut(Cart cart, String fullName, String address, String city, 
			String email, String phone) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		Date checkOutDate = cal.getTime();
		Date checkOutTime = cal.getTime();
		boolean checkOut = true;
		
		cart.setCheckOut(true);
		cart.setFullName(fullName);
		cart.setAddress(address);
		cart.setCity(city);
		cart.setEmail(email);
		cart.setPhone(phone);
		cart.setAddedDate(cal.getTime());
		cart.setAddedTime(cal.getTime());
		cartRepository.setCartDetail(checkOut, fullName, address, city, email, phone, 
				checkOutDate, checkOutTime, cart.getCartId() );
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

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return cartRepository.findByCartId(cartId);
	}

}
