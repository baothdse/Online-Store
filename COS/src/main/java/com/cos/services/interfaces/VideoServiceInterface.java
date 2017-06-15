package com.cos.services.interfaces;

import com.cos.entities.Videos;

public interface VideoServiceInterface {
	Videos addVideo(String link, int userId);
	void deleteVideo(int videoId);
}
