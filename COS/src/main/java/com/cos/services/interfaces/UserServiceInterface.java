package com.cos.services.interfaces;

import com.cos.entities.User;

public interface UserServiceInterface {
	User login(String username, String password);
}
