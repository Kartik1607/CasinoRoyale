package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.ResponseModel;

@Service
public class ImageService {
	
	private final String UPLOADED_FOLDER = "images/";
	
	public ResponseModel<String> saveImage(MultipartFile file) {
		ResponseModel<String> response = new ResponseModel<String>();
		String fileName = UUID.randomUUID().toString();
		file.getContentType();
		if (file.isEmpty()) {
			response.setError("Empty File");
			response.setSuccess(false);
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName + file.getOriginalFilename());
			Files.write(path, bytes);
			response.setSuccess(true);
			response.setData( fileName + file.getOriginalFilename() );
		} catch (IOException e) {
			response.setSuccess(false);
			response.setError(e.toString());
		}
		return response;
	}
	
	public ResponseModel<byte[]> getFile(String fileName) {
		ResponseModel<byte[]> response = new ResponseModel<>();
		byte[] bytes;
		Path path = Paths.get(UPLOADED_FOLDER + fileName);
		try {
			bytes = Files.readAllBytes(path);
			response.setData(bytes);
			response.setSuccess(true);
		} catch (IOException e) {
			response.setSuccess(false);
			response.setError(e.toString());
			e.printStackTrace();
		}
		return response;
	}
	
}
