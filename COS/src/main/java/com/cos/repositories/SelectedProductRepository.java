package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cos.entities.SelectedProduct;

public interface SelectedProductRepository extends JpaRepository<SelectedProduct, Integer> {
	
	@Query("select sp from SelectedProduct sp where sp.user.userId = :userId and sp.checkOut = false")
	List<SelectedProduct> findByUserId(@Param("userId") int userId);
}
