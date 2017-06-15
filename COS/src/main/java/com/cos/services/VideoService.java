package com.cos.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Videos;
import com.cos.repositories.UserRepository;
import com.cos.repositories.VideoRepository;
import com.cos.services.interfaces.VideoServiceInterface;

@Service
@Transactional
public class VideoService implements VideoServiceInterface{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VideoRepository videoRepository;
	
	@Override
	public Videos addVideo(String link, int userId) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		Videos video = new Videos();
		video.setLink(link);
		video.setUser(userRepository.findByUserId(userId));
		video.setAddedDate(cal.getTime());
		video.setAddedTime(cal.getTime());
		videoRepository.save(video);
		return video;
	}

	@Override
	public void deleteVideo(int videoId) {
		// TODO Auto-generated method stub
		videoRepository.delete(videoRepository.findByVideoId(videoId));
	}

}
