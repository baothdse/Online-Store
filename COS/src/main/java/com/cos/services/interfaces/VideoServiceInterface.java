package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.Videos;

public interface VideoServiceInterface {
	Videos addVideo(String link, int userId);
	void deleteVideo(int videoId);
	List<Videos> get2LatestVideo();
}
