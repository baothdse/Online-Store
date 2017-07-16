package com.cos.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cos.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p from Product p order by p.addedDate, p.addedTime")
	List<Product> findAll();
	
	@Query("select p from Product p where p.productKind = :productKind order by p.addedDate asc, p.addedTime asc")
	List<Product> findByProductKind(@Param("productKind") String productKind, Pageable pageable);
	
	@Query("select p from Product p where p.productKind = :productKind order by p.addedDate asc, p.addedTime asc")
	List<Product> findByProductKind(@Param("productKind") String productKind);
	
	Product findByProductId(Integer productId);
	
	Product findByProductName(String productName);
	
	@Modifying
	@Query("update Product p set p.introduction = ?1, p.productKind = ?2,"
			+ "p.brand = ?3, p.price = ?4, p.productQuantity = ?5, p.addedDate = ?6, p.addedTime = ?7 "
			+ "where p.productId = ?8")
	void setProductInfoById (String introduction, String productKind, String brand, 
			String price, int productQuantity, Date addedDate, Date addedTime, int productId);
	
	@Modifying
	@Query("update Product p set p.discount.discountId = ?1 where p.productId = ?2")
	void setDiscountByProductId(int discountId, int productId);
	
	
}
