package com.cos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.entities.Image;
import com.cos.entities.Product;
import com.cos.repositories.ImageRepository;
import com.cos.repositories.ProductRepository;
import com.cos.services.interfaces.ImageServiceInterface;

@Service
@Transactional
public class ImageService implements ImageServiceInterface {

	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ProductRepository productRepository;	

	@Override
	public Image addImage(String link, int productId, boolean main) {
		// TODO Auto-generated method stub
		Image image = new Image();
		Product product = productRepository.findByProductId(productId);
		image.setLink(link);
		image.setProduct(product);
		image.setMain(main);
		imageRepository.save(image);
		return image;
	}

}
