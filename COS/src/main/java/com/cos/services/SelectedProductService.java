package com.cos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Cart;
import com.cos.entities.Product;
import com.cos.entities.SelectedProduct;
import com.cos.repositories.CartRepository;
import com.cos.repositories.ProductRepository;
import com.cos.repositories.SelectedProductRepository;
import com.cos.services.interfaces.SelectedProductServiceInterface;

@Service
@Transactional
public class SelectedProductService implements SelectedProductServiceInterface {

	@Autowired
	private SelectedProductRepository selectedProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public SelectedProduct selectProduct(int productId, int quantity) {
		// TODO Auto-generated method stub
		SelectedProduct selectedProduct = new SelectedProduct();
		Product product = productRepository.findByProductId(productId);
		
		selectedProduct.setProduct(product);
		selectedProduct.setQuantity(quantity);
		//selectedProductRepository.save(selectedProduct);
		return selectedProduct;
	
	}

	@Override
	public void removeProductFromCart(int selectedId, int cartId) {
		// TODO Auto-generated method stub
		SelectedProduct productInCart = selectedProductRepository.findBySelectedId(selectedId);
		Cart cart = cartRepository.findByCartId(cartId);
		cart.getSelectedproducts().remove(cart.getSelectedproducts().indexOf(productInCart));
		selectedProductRepository.delete(productInCart);
		String newTotalPrice = String.valueOf(recountPrice(cart));
		cart.setTotalPrice(newTotalPrice);
		cartRepository.setTotalPriceByCartId(newTotalPrice, cartId);
	}

	@Override
	public int recountPrice(Cart cart) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		List<SelectedProduct> productInCart = cart.getSelectedproducts();
		for (int index = 0; index < productInCart.size(); index++) {
			totalPrice += productInCart.get(index).getQuantity() * 
					Integer.parseInt(productInCart.get(index).getProduct().getPrice());
		}
		return totalPrice;
	}

	@Override
	public SelectedProduct getSelectedById(int selectedId) {
		// TODO Auto-generated method stub
		return selectedProductRepository.findBySelectedId(selectedId);
	}

	@Override
	public SelectedProduct saveSelected(SelectedProduct selected) {
		// TODO Auto-generated method stub
		return selectedProductRepository.save(selected);
	}

}
