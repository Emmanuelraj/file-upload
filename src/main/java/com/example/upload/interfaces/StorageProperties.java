package com.example.upload.interfaces;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("storage")
public class StorageProperties 
{
	
	/**
	 * Folder location for storing files
	 */
	private String location="upload-dirctory";

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	

}
