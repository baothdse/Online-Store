package com.cos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.ParamConstants;
import com.cos.constants.URLConstant;
import com.cos.entities.Cart;
import com.cos.services.interfaces.CartServiceInterface;
import com.cos.services.interfaces.SelectedProductServiceInterface;

@RestController
@RequestMapping(value = URLConstant.CART_URL)
public class CartController {

	@Autowired
	private CartServiceInterface cartServiceInterface;
	
	@Autowired
	private SelectedProductServiceInterface selectedProductService;

	
//	@RequestMapping(value = URLConstant.GET_ALL_CART, method = RequestMethod.GET)
//	public ResponseEntity <?> getAllCart() {
//		List<Cart> listOfCart = cartServiceInterface.getAllCart();
//		return new ResponseEntity<List<Cart>> (listOfCart, HttpStatus.OK);
//	}
//	
//	@RequestMapping( value = URLConstant.GET_CART_BY_USER, method = RequestMethod.GET)
//	public ResponseEntity <?> getCartById(@RequestParam(ParamConstants.CART_ID) int userId) {
//		List<Cart> cart = cartServiceInterface.getCartByUserId(userId);
//		return new ResponseEntity<List<Cart>> (cart, HttpStatus.OK);
//	}
	
	@RequestMapping(value = URLConstant.ADD_PRODUCT_TO_CART, method = RequestMethod.POST)
	public ResponseEntity<?> addProductToCart(@RequestParam(ParamConstants.USER_ID) int userId,
											@RequestParam(ParamConstants.PRODUCT_ID) int productId,
											@RequestParam(ParamConstants.PRODUCT_QUANTITY) int quantity) {
		selectedProductService.selectProduct(userId, productId, quantity);
		Cart cart = cartServiceInterface.addSelectedProductToCart(userId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.CHECK_OUT, method = RequestMethod.POST)
	public ResponseEntity<?> checkOut(@RequestParam(ParamConstants.USER_ID) int userId,
									@RequestParam(ParamConstants.NOTE) String note) {
		cartServiceInterface.checkOut(userId, note);
		List<Cart> listOfCartByUser = cartServiceInterface.getCartByUserId(userId);
		return new ResponseEntity<List<Cart>> (listOfCartByUser, HttpStatus.OK);
	}
	
	//Only Admin can use this method
	@RequestMapping(value = URLConstant.GET_CHECKED_OUT_CART, method = RequestMethod.GET)
	public ResponseEntity<?> getCheckedOutCarts	() {
		List<Cart> checkedOutCarts = cartServiceInterface.getCheckOutCart();
		return new ResponseEntity<List<Cart>> (checkedOutCarts, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.GET_CHECKED_OUT_CART_BY_USER, method = RequestMethod.GET)
	public ResponseEntity<?> getCheckedOutCartsByUser(@RequestParam(ParamConstants.USER_ID) int userId) {
		List<Cart> checkedOutCarts = cartServiceInterface.getCheckOutCartByUserId(userId);
		return new ResponseEntity<List<Cart>> (checkedOutCarts, HttpStatus.OK);
	}
		
	@RequestMapping(value = URLConstant.GET_CART_DETAIL, method = RequestMethod.GET)
	public ResponseEntity<?> getCartDetail(@RequestParam(ParamConstants.CART_ID) int cartId) {
		Cart cartDetail = cartServiceInterface.getCartDetail(cartId);
		return new ResponseEntity<Cart> (cartDetail, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.REMOVE_PRODUCT, method = RequestMethod.POST)
	public ResponseEntity<?> removeProductFromCart(@RequestParam(ParamConstants.SELECTED_ID) int selectedId,
												@RequestParam(ParamConstants.CART_ID) int cartId) {
		selectedProductService.removeProductFromCart(selectedId, cartId);
		Cart cart = cartServiceInterface.getCartDetail(cartId);
		return new ResponseEntity<Cart> (cart, HttpStatus.OK);
	}
			
}
