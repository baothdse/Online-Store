package com.cos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.ErrorConstants;
import com.cos.entities.User;
import com.cos.errors.Error;
import com.cos.services.interfaces.UserServiceInterface;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceInterface userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestParam(value = "username") String username,
									@RequestParam(value ="password") String password) {
		User user = userService.login(username, password);
		Error error = new Error(ErrorConstants.ER001, ErrorConstants.EM001);
		if (user != null) {
			return new ResponseEntity<User> (user, HttpStatus.OK);
		} else {
			return new ResponseEntity<Error> (error, HttpStatus.OK);
		}
	}
}
