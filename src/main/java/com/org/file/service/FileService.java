package com.org.file.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Value("${file.uploadPath}")
    private String filePath;


    public String uploadFile(MultipartFile file){
        logger.info("Method invoked: uploadFile()");

        try {
            File destination = new File(filePath + File.separator + file.getOriginalFilename());
            logger.info("Injected filepath: {}", filePath);
            file.transferTo(destination);
            return file.getOriginalFilename();
        }
        catch (IOException e){
            logger.error("IO exception");
            throw new RuntimeException("File upload failed");
        }
    }
}
