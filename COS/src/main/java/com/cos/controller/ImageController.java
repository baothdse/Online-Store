package com.cos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.constants.ParamConstants;
import com.cos.constants.URLConstant;
import com.cos.entities.Image;
import com.cos.services.interfaces.ImageServiceInterface;

@RestController
@RequestMapping(value = URLConstant.IMAGE_URL)
public class ImageController {
	
	@Autowired
	private ImageServiceInterface imageServiceInterface;
	
	@RequestMapping(value = URLConstant.ADD_IMAGE_URL, method = RequestMethod.POST)
	public ResponseEntity<?> addImage(@RequestParam(ParamConstants.LINK) String link,
									@RequestParam(ParamConstants.PRODUCT_ID) int productId,
									@RequestParam(ParamConstants.MAIN) boolean main) {
		Image image = imageServiceInterface.addImage(link, productId, main);
		return new ResponseEntity<Image> (image, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.GET_ALL_IMAGE, method = RequestMethod.GET)
	public ResponseEntity<?> getAllImage() {
		List<Image> listOfImage = imageServiceInterface.getAllImage();
		return new ResponseEntity<List<Image>> (listOfImage, HttpStatus.OK);
	}
	
	@RequestMapping(value = URLConstant.CHANGE_MAIN_IMAGE, method = RequestMethod.POST)
	public ResponseEntity<?> changeMainImage(@RequestParam(ParamConstants.IMAGE_ID) Integer imageId,
											@RequestParam(ParamConstants.NEW_IMAGE) String newImage) {
		Image image = imageServiceInterface.getImageById(imageId);
		imageServiceInterface.changeMainImage(image, newImage);
		return new ResponseEntity<Image> (image, HttpStatus.OK);
	}
//	public ResponseEntity<?> changeMainImage(@RequestParam(ParamConstants.IMAGE_ID) Integer imageId) {
//		Image image = imageServiceInterface.getImageById(imageId);
//		imageServiceInterface.changeMainImage(image);
//		return new ResponseEntity<Image> (image, HttpStatus.OK);
//	}
	@RequestMapping(value = URLConstant.DELETE_IMAGE, method = RequestMethod.POST)
	public ResponseEntity<?> deleteImageByProduct(@RequestParam(ParamConstants.PRODUCT_ID) int productId) {
		String delSuccess = "delete successful";
		imageServiceInterface.deleteImageByProduct(productId);
		return new ResponseEntity<String> (delSuccess, HttpStatus.OK);
	}
	
}
