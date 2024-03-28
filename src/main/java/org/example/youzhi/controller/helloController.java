package org.example.youzhi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class helloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @PostMapping("/file")
    public void fileUpload(MultipartFile files) {
        System.out.println(files);
    }
}
