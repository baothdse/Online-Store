package com.cos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.ParamConstants;
import com.cos.constants.URLConstant;
import com.cos.entities.News;
import com.cos.services.interfaces.NewsServiceInterface;

@RestController
@RequestMapping(value = URLConstant.NEWS)
public class NewsController {

	@Autowired
	private NewsServiceInterface newServiceInterface;

	@RequestMapping(value = URLConstant.ADD_NEWS, method = RequestMethod.POST)
	public ResponseEntity<?> addNew(@RequestParam(ParamConstants.HEADER) String header,
			@RequestParam(ParamConstants.CONTENT) String content, @RequestParam(ParamConstants.USER_ID) int userId) {
		News addedNew = newServiceInterface.addNew(header, content, userId);
		return new ResponseEntity<News>(addedNew, HttpStatus.OK);
	}

	@RequestMapping(value = URLConstant.GET_3_NEWS, method = RequestMethod.GET)
	public ResponseEntity<?> get4News() {
		List<News> top4News = newServiceInterface.get4LatestNews();
		return new ResponseEntity <List<News>>(top4News, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.DELETE_NEW, method = RequestMethod.POST)
	public ResponseEntity<?> deleteNew(@RequestParam(ParamConstants.NEW_ID) int newId) {
		String successful = "Delete new successful!";
		newServiceInterface.deleteNew(newId);
		return new ResponseEntity <String>(successful, HttpStatus.OK);
	}
}
