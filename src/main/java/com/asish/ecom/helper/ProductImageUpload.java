package com.asish.ecom.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProductImageUpload {
	
	public final String UPLOAD_DIR = "D:\\spring-tool-suite\\spring-boot-workspace\\ecom\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile file) throws IOException {
		boolean tmp = false;
		Files.copy(file.getInputStream(),
					Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
		tmp=true;	
		
		return tmp;
	}
}
