package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	
	@Query("select i from Image i where i.product.productId = :productId")
	List<Image> findByProduct(@Param("productId") Integer productId);
	
	Image findByImageId(Integer imageId);
	
	@Modifying
	@Query("update Image i set i.main = ?1 where i.imageId = ?2")
	void setFixedMainFor(boolean main, int imageId);
}
