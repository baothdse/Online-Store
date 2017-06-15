package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.entities.News;

public interface NewsRepository extends JpaRepository<News, Integer> {
	News findByNewId(int newId);
	List<News> findTop4ByOrderByAddedDateDesAndAddedTimeDes();
}
	