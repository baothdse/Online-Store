package com.cos.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.constants.ParamConstants;
import com.cos.constants.URLConstant;
import com.cos.entities.Discount;
import com.cos.services.interfaces.DiscountServiceInterface;

@Controller
@RequestMapping(value = URLConstant.DISCOUNT_URL)
public class DiscountController {

	@Autowired
	private DiscountServiceInterface discountServiceInterface;

	@RequestMapping(value = URLConstant.ADD_DISCOUNT_URL, method = RequestMethod.POST)
	public ResponseEntity<?> addImage(@RequestParam(ParamConstants.DISCOUNT_CODE) String discountCode,
									@RequestParam(ParamConstants.START_DATE) String startDate, 
									@RequestParam(ParamConstants.END_DATE) String endDate,
									@RequestParam(ParamConstants.AMOUNT) int amount) throws ParseException {
		Discount discount = discountServiceInterface.createDiscount(discountCode, startDate, endDate, amount);
		return new ResponseEntity<Discount>(discount, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.DEL_DISCOUNT_URL, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteImage(@RequestParam(ParamConstants.DISCOUNT_ID) int discountId) {
		discountServiceInterface.deleteDiscount(discountId);
		return new ResponseEntity<String> (HttpStatus.OK);
	}
	
}
