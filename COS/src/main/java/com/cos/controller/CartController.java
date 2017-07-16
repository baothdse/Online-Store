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
import com.cos.entities.SelectedProduct;
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
	
	
	/**
	 * Use when customer add the first product
	 * @param productId
	 * @param quantity
	 * @return
	 */
	@RequestMapping(value = URLConstant.ADD_PRODUCT_TO_CART, method = RequestMethod.POST)
	public ResponseEntity<?> addProductToCart(@RequestParam(ParamConstants.PRODUCT_ID) int productId,
											@RequestParam(ParamConstants.SOLD_QUANTITY) int quantity) {
		SelectedProduct selectedProduct = selectedProductService.selectProduct(productId, quantity);
		selectedProductService.saveSelected(selectedProduct);
		Cart cart = cartServiceInterface.addSelectedProductToCart(selectedProduct.getSelectedId());
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	
	/**
	 * This API will be called when customer want add the next product
	 * @param productId
	 * @param quantity
	 * @param cartId
	 * @return
	 */
	@RequestMapping(value = URLConstant.UPDATE_CART, method = RequestMethod.POST)
	public ResponseEntity<?> updateCart(@RequestParam(ParamConstants.PRODUCT_ID) int productId,
										@RequestParam(ParamConstants.SOLD_QUANTITY) int quantity,
										@RequestParam(ParamConstants.CART_ID) int cartId){
		SelectedProduct selectedProduct = selectedProductService.selectProduct(productId, quantity);
		Cart cart = cartServiceInterface.updateCart(selectedProduct, cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	
	/**
	 * Use when customer check out
	 * @param cartId
	 * @param fullName
	 * @param address
	 * @param city
	 * @param email
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = URLConstant.CHECK_OUT, method = RequestMethod.POST)
	public ResponseEntity<?> checkOut(@RequestParam(ParamConstants.CART_ID) int cartId,
									@RequestParam(ParamConstants.FULL_NAME) String fullName,
									@RequestParam(ParamConstants.ADDRESS) String address,
									@RequestParam(ParamConstants.CITY) String city,
									@RequestParam(ParamConstants.EMAIL) String email,
									@RequestParam(ParamConstants.PHONE) String phone) {
		Cart cart = cartServiceInterface.getCartById(cartId);
		cartServiceInterface.checkOut(cart, fullName, address, city, email, phone);
		return new ResponseEntity<Cart> (cart, HttpStatus.OK);
	}
	
	/**
	 * Only Admin can use this method
	 * 
	 * @return checkedOutCart order by date, time ASC
	 */
	@RequestMapping(value = URLConstant.GET_CHECKED_OUT_CART, method = RequestMethod.GET)
	public ResponseEntity<?> getCheckedOutCarts	() {
		List<Cart> checkedOutCarts = cartServiceInterface.getCheckOutCart();
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
	
	@RequestMapping(value = URLConstant.GET_SELECTED_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<?> removeProductFromCart(@RequestParam(ParamConstants.SELECTED_ID) int selectedId) {
		SelectedProduct selected = selectedProductService.getSelectedById(selectedId);
		return new ResponseEntity<SelectedProduct> (selected, HttpStatus.OK);
	}
}
