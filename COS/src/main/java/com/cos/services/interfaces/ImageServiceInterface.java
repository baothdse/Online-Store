package com.cos.services.interfaces;

import java.util.ArrayList;

import com.cos.entities.Image;

public interface ImageServiceInterface {
	ArrayList<Image> getMainImage(Integer productId);
}
