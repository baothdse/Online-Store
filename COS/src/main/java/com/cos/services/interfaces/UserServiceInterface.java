package com.cos.services.interfaces;

import com.cos.entities.User;

public interface UserServiceInterface {
	User login(String username, String password);
	User register(String username, String password, String firstName, String lastName, String address, 
			String city, String email, String phone);
	
//	User loginUsingFacebook(Facebook facebook);
//	User registerUsingFacebook(Facebook facebook);
}
