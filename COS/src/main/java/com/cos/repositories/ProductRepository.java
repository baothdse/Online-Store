package com.cos.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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
	
	Product findByProductId(Integer productId);
	
	Product findByProductName(String productName);
	
}
