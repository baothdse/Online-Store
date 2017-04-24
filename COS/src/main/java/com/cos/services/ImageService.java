package com.cos.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Image;
import com.cos.repositories.ImageRepository;
import com.cos.services.interfaces.ImageServiceInterface;

@Service
@Transactional
public class ImageService implements ImageServiceInterface {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public ArrayList<Image> getMainImage(Integer productId) {
		// TODO Auto-generated method stub
		return imageRepository.findByProductAndMain(productId, true);
	}

}
