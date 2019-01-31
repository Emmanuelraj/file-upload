package com.example.upload.interfaces;

public class StorageException extends RuntimeException 
{
	
	
	public StorageException(String message) {
		// TODO Auto-genring mrated constructor stub
		
		super(message);
	}
	
	
	public StorageException(String message,Throwable cause)
	{
		super(message, cause);
	}

}
