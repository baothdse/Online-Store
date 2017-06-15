package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.News;

public interface NewsServiceInterface {
	News addNew(String header, String content, int userId);
	List<News> get4LatestNews();
	void deleteNew(int newId);
}
