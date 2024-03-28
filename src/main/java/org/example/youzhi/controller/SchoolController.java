package org.example.youzhi.controller;

import org.example.youzhi.service.SchoolService;
import org.example.youzhi.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SchoolController {

    @Resource
    private SchoolService schoolService;

    @GetMapping("/getSchoolBySchoolVariety")
    public R getSchoolBySchoolVariety(Integer schoolVariety){
        return R.success("schools", schoolService.querySchoolBySchoolVariety(schoolVariety));
    }
}
