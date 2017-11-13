package com.example.demo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	public class Response<T> {
		public T data;
		public String error;
		public  boolean success;
	}
	
	private final String UPLOADED_FOLDER = "images/";
	
	public Response<String> saveImage(MultipartFile file) {
		Response<String> response = new Response<String>();
		String fileName = UUID.randomUUID().toString();
		file.getContentType();
		if (file.isEmpty()) {
			response.error = "EMPTY FILE";
			response.success = false;
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName + file.getOriginalFilename());
			Files.write(path, bytes);
			response.success = true;
			response.data = fileName + file.getOriginalFilename();
		} catch (IOException e) {
			response.success = false;
			response.error = e.toString();
		}
		return response;
	}
	
	public Response<byte[]> getFile(String fileName) {
		Response<byte[]> response = new Response<>();
		byte[] bytes;
		Path path = Paths.get(UPLOADED_FOLDER + fileName);
		try {
			bytes = Files.readAllBytes(path);
			response.data = bytes;
			response.success = true;
			System.out.println(response.data);
		} catch (IOException e) {
			response.success = false;
			response.data = null;
			response.error = e.toString();
			e.printStackTrace();
		}
		return response;
	}
	
}
