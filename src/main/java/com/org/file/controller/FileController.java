package com.org.file.controller;

import com.org.file.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model){
        logger.info("Method invoked: uploadFile()");
        if (file.isEmpty()){
            logger.info("File is empty");
            model.addAttribute("message", "There is no file.");
            return "index";
        }

        try {
            String fileName = fileService.uploadFile(file);
            logger.info("{} file uploaded successfully", fileName);
            model.addAttribute("message", "File uploaded successfully "+fileName);
        }
        catch (RuntimeException e){
            logger.error("File upload failed {}", e.getMessage());
            model.addAttribute("message", "File upload failed ");
            return "index";
        }

        return "index";

    }
}
