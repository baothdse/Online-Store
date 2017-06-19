package com.cos.services.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.cos.entities.User;
import com.cos.repositories.UserRepository;
@Service
public class FacebookConnectionSignUp implements ConnectionSignUp {

	@Autowired
	private UserRepository userRepository;
	@Override
	public String execute(Connection<?> connection) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(connection.getDisplayName());
		user.setPassword("123456");
		userRepository.save(user);
		return user.getUsername();
	}

}
