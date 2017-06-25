package com.lumiseven.test_springMVC4.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file){
		try {
			FileUtils.writeByteArrayToFile(new File("/home/seven/Downloads/" + (new Date()).toString().replaceAll(" ", "_") + ".txt"), file.getBytes());
			return "ok";
		} catch (IOException e) {
			e.printStackTrace();
			return "wrong";
		}
	}
}
