package com.cos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Discount;
import com.cos.repositories.DiscountRepository;
import com.cos.repositories.ProductRepository;
import com.cos.services.interfaces.DiscountServiceInterface;
@Service
@Transactional
public class DiscountService implements DiscountServiceInterface {
	
	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Discount createDiscount(String discountCode, String startDate, String endDate, int amount) 
			throws ParseException {
		// TODO Auto-generated method stub
		Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
		Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		
		Discount discount = new Discount();
		discount.setDiscountCode(discountCode);
		discount.setStartDate(dateStart);
		discount.setEndDate(dateEnd);
		discount.setAmount(amount);
		discountRepository.save(discount);
		return discount;
	}

	@Override
	public void deleteDiscount(int discountId) {
		// TODO Auto-generated method stub
		Discount discount = getDiscountById(discountId);
		discountRepository.delete(discount);
	}

	@Override
	public Discount getDiscountById(int discountId) {
		// TODO Auto-generated method stub
		Discount discount = discountRepository.findByDiscountId(discountId);
		return discount;
	}

	@Override
	public List<Discount> getALLDiscount() {
		// TODO Auto-generated method stub
		discountRepository.findAll();
		return null;
	}

	@Override
	public void applyDiscount(int discountId, ArrayList<Integer> listOfProductId) {
		// TODO Auto-generated method stub
		for (int index = 0; index < listOfProductId.size(); index++) {
			productRepository.setDiscountByProductId(discountId, listOfProductId.get(index));
		}
		
	}

}
