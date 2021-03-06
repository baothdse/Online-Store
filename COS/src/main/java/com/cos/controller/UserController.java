package com.cos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.ErrorConstants;
import com.cos.constants.ParamConstants;
import com.cos.constants.URLConstant;
import com.cos.entities.User;
import com.cos.errors.Error;
import com.cos.services.interfaces.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInterface userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam(ParamConstants.USERNAME) String username,
									@RequestParam(ParamConstants.PASSWORD) String password) {
		User user = userService.login(username, password);
		Error error = new Error(ErrorConstants.ER001, ErrorConstants.EM001);
		if (user != null) {
			return new ResponseEntity<User> (user, HttpStatus.OK);
		} else {
			return new ResponseEntity<Error> (error, HttpStatus.OK);
		}
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ResponseEntity<?> register(@RequestParam(ParamConstants.USERNAME) String username,
//										@RequestParam(ParamConstants.PASSWORD) String password,
//										@RequestParam(ParamConstants.FIRST_NAME) String firstName,
//										@RequestParam(ParamConstants.LAST_NAME) String lastName,
//										@RequestParam(ParamConstants.ADDRESS) String address,
//										@RequestParam(ParamConstants.CITY) String city,
//										@RequestParam(ParamConstants.EMAIL) String email,
//										@RequestParam(ParamConstants.PHONE) String phone) {
//		Error error = new Error(ErrorConstants.ER002, ErrorConstants.EM002);
//		User user = userService.register(username, password, firstName, lastName, address, city, email, phone);
//		if (user != null ) {
//			return new ResponseEntity<User>(user, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Error> (error, HttpStatus.OK);
//		}
//	}
	
	@RequestMapping(value = URLConstant.GET_USER_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@RequestParam(ParamConstants.USER_ID) int userId) {
		User user = userService.getUserById(userId);
		return new ResponseEntity<User> (user, HttpStatus.OK);
	}

}
