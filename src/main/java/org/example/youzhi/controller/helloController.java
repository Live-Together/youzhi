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
        System.out.println("test branch");
        return "hello world";
    }
}
