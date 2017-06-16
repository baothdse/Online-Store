package com.cos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.entities.Videos;

public interface VideoRepository extends JpaRepository<Videos, Integer> {
	Videos findByVideoId(int videoId);
	
	@Query("select v from Videos v order by v.addedDate desc, v.addedTime desc")
	List<Videos> findTop2Videos();
}
