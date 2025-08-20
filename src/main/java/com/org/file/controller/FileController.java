package com.org.file.controller;

import com.org.file.config.FilePathConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @Value("${file.uploadPath}")
    private String filePath;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model){
        if (file.isEmpty()){
            model.addAttribute("message", "There is no file.");
            return "index";
        }

        try {
            File destination = new File(filePath + File.separator + file.getOriginalFilename());
            System.out.println("Injected filepath: "+filePath);
            file.transferTo(destination);
            model.addAttribute("message", "File uploaded successfully.");
        }
        catch (IOException e){
            e.printStackTrace();
            model.addAttribute("message", "IO Exception");
            return "index";
        }

        return "index";

    }
}
