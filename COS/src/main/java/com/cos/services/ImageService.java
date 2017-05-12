package com.cos.services;

import java.util.List;

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

	@Override
	public List<Image> getAllImage() {
		// TODO Auto-generated method stub
		List<Image> listOfImage = imageRepository.findAll();
		return listOfImage;
	}

	@Override
	public void changeMainImage(Image image) {
		// TODO Auto-generated method stub
		List<Image> listOfImageByProductId = getImageByProductId(image.getProduct().getProductId());
		imageRepository.setFixedMainFor(true, image.getImageId());
		listOfImageByProductId.remove(image);
		for (Image i : listOfImageByProductId) {
			imageRepository.setFixedMainFor(false, i.getImageId());
		}
	}

	@Override
	public Image getImageById(int imageId) {
		// TODO Auto-generated method stub
		return imageRepository.findByImageId(imageId);
	}

	@Override
	public List<Image> getImageByProductId(Integer productId) {
		// TODO Auto-generated method stub
		List<Image> listOfImageByProductId = imageRepository.findByProduct(productId);
		return listOfImageByProductId;
	}

	
}
