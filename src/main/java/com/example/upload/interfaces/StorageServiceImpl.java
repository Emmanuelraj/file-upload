package com.example.upload.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService{

	private final Path rootlocation;
	
	
	//private final Path rootLocationPaths.get(storageProperties.getLocation());
	
	
	@Autowired
	public StorageServiceImpl(StorageProperties  storageProperties) 
	{
		// TODO Auto-generated constructor stub
		this.rootlocation = Paths.get(storageProperties.getLocation());
	}
	
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try
		{
			Files.createDirectories(rootlocation);
		}
		catch(IOException e)
		{
			throw new StorageException("could not initialize");
		}
	
	}

	@Override
	public void store(MultipartFile file) {
		// TODO Auto-generated method stubry
		
		
		
		String filename=StringUtils.cleanPath(file.getOriginalFilename());
		
		try
         {
			if(file.isEmpty())
			{
				throw new StorageException("faile"+filename);
			}
			
			if(filename.contains(".."))
			{
				throw new StorageException("Cannot store file"+filename);
			}
			
			try(InputStream inputStream = file.getInputStream())
			{
				Files.copy(inputStream,this.rootlocation.resolve(filename),
				StandardCopyOption.REPLACE_EXISTING);
			}
		 }
		catch(Exception io)
		{
			throw new StorageException(filename, io);
		}
		
	}

	@Override
	public Stream<Path> loadAll() {
		return null;
		// TODO Auto-generated method stub
//		return rootlocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}
