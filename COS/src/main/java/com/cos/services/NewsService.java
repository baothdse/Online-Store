package com.cos.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.News;
import com.cos.repositories.NewsRepository;
import com.cos.repositories.UserRepository;
import com.cos.services.interfaces.NewsServiceInterface;

@Service
@Transactional
public class NewsService implements NewsServiceInterface {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public News addNew(String header, String content, int userId) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		News news = new News();
		news.setHeader(header);
		news.setContent(content);
		news.setAddedDate(cal.getTime());
		news.setAddedTime(cal.getTime());
		news.setUser(userRepository.findByUserId(userId));
		newsRepository.save(news);
		return news;
	}

	@Override
	public List<News> get4LatestNews() {
		// TODO Auto-generated method stub
		List<News> top4News = newsRepository.findTop3News();
		return top4News;
	}

	@Override
	public void deleteNew(int newId) {
		// TODO Auto-generated method stub
		News delNew = newsRepository.findByNewId(newId);
		newsRepository.delete(delNew);
	}

}
