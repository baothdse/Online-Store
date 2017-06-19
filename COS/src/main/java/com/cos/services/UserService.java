package com.cos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.User;
import com.cos.repositories.UserRepository;
import com.cos.services.interfaces.UserServiceInterface;

@Service
@Transactional
public class UserService implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(String username, String password) {
		User user = userRepository.findByUsername(username);
		System.out.println("bao" + user.getUsername());
		if (!user.getPassword().equals(password) || user == null) {
			return null;
		} 
		return user;
	}

	@Override
	public User register(String username, String password, String firstName, String lastName, String address,
			String city, String email, String phone) {
		// TODO Auto-generated method stub
		User user = new User();
		if (userRepository.findByUsername(username) == null) {
			user.setUsername(username);
			user.setPassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setAddress(address);
			user.setCity(city);
			user.setEmail(email);
			user.setPhone(phone);
			user.setRoleId(2);
			userRepository.save(user);
			return user;
		} else {
			return null;
		}
	}

	private Facebook facebook;
	@Override
	public User loginUsingFacebook(Facebook facebook) {
		// TODO Auto-generated method stub
		List<User> listOfUser = userRepository.findAll();
		User user = new User();
		boolean checkDuplicated = true;
		for (int index = 0; index < listOfUser.size(); index++) {
			if (facebook.userOperations().getUserProfile().getName().equals(listOfUser.get(index).getUsername())) {
				checkDuplicated = true;
				user = listOfUser.get(index);
				return user;
			} else {	
				checkDuplicated =  false; 
			}
		}
		if (checkDuplicated == false) {
			user = registerUsingFacebook(facebook);
		}

		return user;
	}

	@Override
	public User registerUsingFacebook(Facebook facebook) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setFirstName(facebook.userOperations().getUserProfile().getFirstName());
		user.setLastName(facebook.userOperations().getUserProfile().getLastName());
		user.setUsername(facebook.userOperations().getUserProfile().getName());
		user.setRoleId(2);
		userRepository.save(user);
		return user;
	}

}
