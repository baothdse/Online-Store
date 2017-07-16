package com.cos.services.interfaces;

import java.util.List;

import com.cos.entities.Image;

public interface ImageServiceInterface {
	Image addImage(String link, int productId, boolean main);
	List<Image> getAllImage();
	void changeMainImage(Image image, String newImage);
	Image getImageById(int imageId);
	List<Image> getImageByProductId(Integer productId);
}
