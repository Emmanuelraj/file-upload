package com.example.upload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.upload.interfaces.StorageService;

@Controller
public class FileUploadController
{
	@Autowired
	StorageService storageService;
	

	
	@GetMapping("/")
	public String listUploadedFiles()throws IOException
	{
		
		return "UploadForm";
	}

	
	
	@PostMapping("/")
	public String fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
	{
		storageService.store(file);
		
		
		redirectAttributes.addFlashAttribute("message", file.getOriginalFilename());
		
		return "redirect:/";
	}

}
