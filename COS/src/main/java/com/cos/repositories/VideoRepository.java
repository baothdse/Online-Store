package com.cos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.entities.Videos;

public interface VideoRepository extends JpaRepository<Videos, Integer> {
	Videos findByVideoId(int videoId);
}
