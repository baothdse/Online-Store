package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.entities.News;

public interface NewsRepository extends JpaRepository<News, Integer> {
	News findByNewId(int newId);
	@Query("select n from News n order by n.addedDate desc, n.addedTime desc")
	List<News> findTop3News();
}
	