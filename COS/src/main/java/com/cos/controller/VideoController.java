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
import com.cos.entities.Videos;
import com.cos.services.interfaces.VideoServiceInterface;

@RestController
@RequestMapping(value = URLConstant.VIDEO)
public class VideoController {
	@Autowired
	private VideoServiceInterface videoServiceInterface;
	
	@RequestMapping(value = URLConstant.ADD_VIDEO, method = RequestMethod.POST)
	public ResponseEntity<?> addVideo(@RequestParam(ParamConstants.LINK) String link,
									@RequestParam(ParamConstants.USER_ID) int userId) {
		Videos video = videoServiceInterface.addVideo(link, userId);
		return new ResponseEntity<Videos>(video, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.DELETE_VIDEO, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteVideo(@RequestParam(ParamConstants.VIDEO_ID) int videoId) {
		String status = "Delete successful";
		videoServiceInterface.deleteVideo(videoId);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	@RequestMapping(value = URLConstant.GET_2_VIDEO, method = RequestMethod.GET)
	public ResponseEntity<?> get2LatestVideo() {
		List<Videos> top2Videos = videoServiceInterface.get2LatestVideo();
		return new ResponseEntity <List<Videos>>(top2Videos, HttpStatus.OK);
	}
}
