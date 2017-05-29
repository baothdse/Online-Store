package com.cos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.entities.Discount;

@Repository
public interface DiscountRepository extends JpaRepository <Discount,Integer> {
	Discount findByDiscountId (int discountId);
}
