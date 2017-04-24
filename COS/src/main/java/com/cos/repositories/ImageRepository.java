package com.cos.repositories;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	@Query("Select i from Image i where i.product.productId = :productId")
	Set<Image> findByProduct(@Param("productId") Integer productId);
	@Query("Select i from Image i where i.product.productId = :productId and :main = true")
	ArrayList<Image> findByProductAndMain(@Param("productId") Integer productId, 
									@Param("main") boolean main);
}
