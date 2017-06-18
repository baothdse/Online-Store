package com.cos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(int userId);
	User findByUsername(String username);
}
