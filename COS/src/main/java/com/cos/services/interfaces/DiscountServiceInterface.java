package com.cos.services.interfaces;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cos.entities.Discount;

public interface DiscountServiceInterface {
	Discount createDiscount(String discountCode, String startDate, String endDate, 
			int amount) throws ParseException;
	
	void deleteDiscount(int discountId);
	Discount getDiscountById(int discountId);
	List<Discount> getALLDiscount();
	void applyDiscount(int discountId, ArrayList<Integer> listOfProductId);
}
