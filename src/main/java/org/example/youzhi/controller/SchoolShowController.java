package org.example.youzhi.controller;

import org.example.youzhi.pojo.SchoolShow;
import org.example.youzhi.service.SchoolShowService;
import org.example.youzhi.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SchoolShowController {

    @Resource
    private SchoolShowService schoolShowService;

    @GetMapping("/getAllSchoolShow")
    public R getAll(){
        return R.success("schoolShow", schoolShowService.queryAll());
    }
}
