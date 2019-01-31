package com.example.upload.interfaces;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService
{
	
	void init();
	
	void store(MultipartFile file);
	
	Stream<Path> loadAll();
	
		
	Resource loadAsResource(String filename);
	
	
	void deleteAll();

}
