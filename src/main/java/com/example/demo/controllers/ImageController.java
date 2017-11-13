package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.ImageService;
import com.example.demo.services.ImageService.Response;

@CrossOrigin
@Controller
@RequestMapping("/images")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@GetMapping(value="/{id:.+}", produces={"image/jpeg", "image/png"})
	public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
	    Response<byte[]> image = imageService.getFile(id);
	    return new ResponseEntity<>(image.data, HttpStatus.OK);
	}
}
