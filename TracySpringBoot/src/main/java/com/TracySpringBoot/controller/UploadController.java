package com.TracySpringBoot.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.TracySpringBoot.model.modelinfo;
import com.TracySpringBoot.service.infoService;


@RestController
public class UploadController{
	
	@Autowired
	infoService fileService;

	@RequestMapping(value = "/files/{fileid}", method = RequestMethod.POST)
	public String uploadFileHandler(@PathVariable("fileid") Integer fileid, @RequestParam("files") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				// Store file to local disk
				File dir = new File("src/main/resources/files");
				String name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				String path = dir.getAbsolutePath() + File.separator + name;
				File savedFile = new File(path);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(savedFile));
				stream.write(bytes);
				stream.close();
				
				// Store meta-data to database
				Long size = savedFile.length();
				fileService.saveIn(new modelinfo(fileid,name,size,path));
				
				return "Successfully uploaded file: "+name ;

			} catch (Exception e) {
				return "Failed to upload file:  " + e.getMessage();
			}
		} else {
			return "Failed to upload file:  the file was empty.";
		}
	}
	
	
	@RequestMapping("/files/{id}/info")
	public modelinfo getFileInfo(@PathVariable  Integer id) {
		return fileService.ById(id);
	}


}