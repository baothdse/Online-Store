package com.cos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.URLConstant;
import com.cos.entities.Product;
import com.cos.services.interfaces.ProductServiceInterface;

@RestController
@RequestMapping(value = URLConstant.PRODUCT_URL)
public class ProductController {

	@Autowired
	private ProductServiceInterface productServiceInterface;
	
	@RequestMapping(value = URLConstant.NEWEST_PRODUCT_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getAllProduct() {
		Product product = productServiceInterface.getNewestProduct();
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.BEST_SELLING_PRODUCT_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getBestSellingProduct() {
		Product product = productServiceInterface.getBestSellingProduct();
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/related", method = RequestMethod.GET)
	public ResponseEntity<?> getRelatedProduct(@RequestParam("productKind") String productKind) {
		List<Product> listOfProduct = productServiceInterface.getRelatedProduct(productKind);
		return new ResponseEntity<List<Product>> (listOfProduct, HttpStatus.OK);
	}
}
