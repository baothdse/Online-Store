package com.cos.services.interfaces;

import com.cos.entities.Image;

public interface ImageServiceInterface {
	Image addImage(String link, int productId, boolean main);
}
