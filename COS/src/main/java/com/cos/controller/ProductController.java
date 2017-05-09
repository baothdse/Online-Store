package com.cos.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.ErrorConstants;
import com.cos.constants.ParamConstants;
import com.cos.constants.URLConstant;
import com.cos.entities.Product;
import com.cos.errors.Error;
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
	
	@RequestMapping(value = URLConstant.RELATED_PRODUCT_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getRelatedProduct(@RequestParam(ParamConstants.PRODUCT_KIND) String productKind) {
		List<Product> listOfProduct = productServiceInterface.getRelatedProduct(productKind);
		return new ResponseEntity<List<Product>> (listOfProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.PRODUCT_DETAIL_URL, method = RequestMethod.GET)
	public ResponseEntity<?> getProductDetail(@RequestParam(ParamConstants.PRODUCT_ID) int productId) {
		Product product = productServiceInterface.getProductById(productId);
		product.getImages().remove(null);
		return new ResponseEntity<Product> (product, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.CREATE_PRODUCT_URL, method = RequestMethod.POST)
	public ResponseEntity<?> createProduct(@RequestParam(ParamConstants.PRODUCT_NAME) String productName,
											@RequestParam(ParamConstants.INTRODUCTION) String introduction,
											@RequestParam(ParamConstants.PRODUCT_KIND) String productKind,
											@RequestParam(ParamConstants.BRAND) String brand,
											@RequestParam(ParamConstants.PRICE) String price,
											@RequestParam(ParamConstants.PRODUCT_QUANTITY) int productQuantity) {
		Product product = productServiceInterface.createProduct(productName, introduction, productKind, brand, price,
				productQuantity);
		Error error = new Error(ErrorConstants.ER003, ErrorConstants.EM003);
		if (product != null) {
			return new ResponseEntity<Product> (product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Error> (error, HttpStatus.OK); 
		}		
	}
	
	@RequestMapping(value = URLConstant.GET_PRODUCT_BY_KIND_URL, method = RequestMethod.GET)
	public ResponseEntity<?> get4ProductByProductKind(@RequestParam(ParamConstants.PRODUCT_KIND) String productKind) {
		List<Product> groupOf4ProductByKind = productServiceInterface.get4ProductByProductKind(productKind);
		return new ResponseEntity<List<Product>> (groupOf4ProductByKind, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.DELETE_PRODUCT_URL, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@RequestParam(ParamConstants.PRODUCT_ID) int productId) {
		productServiceInterface.deleteProductById(productId);
		List<Product> listOfProduct = productServiceInterface.getAllProduct();
		return new ResponseEntity<List<Product>> (listOfProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<?> updateProductInfo(@RequestParam(ParamConstants.INTRODUCTION) String introduction,
											@RequestParam(ParamConstants.PRODUCT_KIND) String productKind,
											@RequestParam(ParamConstants.BRAND) String brand,
											@RequestParam(ParamConstants.PRICE) String price,
											@RequestParam(ParamConstants.PRODUCT_QUANTITY) int productQuantity,
											@RequestParam(ParamConstants.PRODUCT_ID) int productId){
		Calendar calendar = Calendar.getInstance();
		Date datetime = calendar.getTime();
		productServiceInterface.updateProductInfo(introduction, productKind, 
				brand, price, productQuantity, datetime, datetime, productId);
		Product product = productServiceInterface.getProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
											
}
