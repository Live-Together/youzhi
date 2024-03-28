package org.example.youzhi.controller;

import org.example.youzhi.pojo.SchoolInfo;
import org.example.youzhi.service.SchoolInfoService;
import org.example.youzhi.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@RestController
public class SchoolInfoController {
    @Resource
    private SchoolInfoService schoolInfoService;

    @GetMapping("/getSchoolInfo")
    public R getSchoolInfo(int pageIndex, String schoolName, String majorName, String year, String majorVariety, String schoolVariety){
        SchoolInfo schoolInfo = new SchoolInfo(null,
                null,
                null,
                schoolName,
                schoolVariety.isEmpty() ? null: Integer.parseInt(schoolVariety),
                null,
                majorName,
                year,
                majorVariety.isEmpty() ? null: Integer.parseInt(majorVariety),
                null);
        return R.success("list", schoolInfoService.querySchoolInfo(pageIndex, schoolInfo));
    }

    @PostMapping("/getSchoolInfoCount")
    public R getSchoolInfoCount(@RequestBody SchoolInfo schoolInfo){
        return R.success("total", schoolInfoService.querySchoolInfoCount(schoolInfo));
    }

    @GetMapping("/getSchoolInfoBySchoolName")
    public R getSchoolInfoBySchoolName(String schoolName){
        return R.success("all schoolInfo", schoolInfoService.querySchoolInfoBySchoolName(schoolName));
    }

    @GetMapping("/getSchoolInfoByMajorName")
    public R getSchoolInfoByMajorName(String majorName){
        return R.success("all schoolInfo", schoolInfoService.querySchoolInfoByMajorName(majorName));
    }

    @GetMapping("/getSchoolByScore")
    public R getSchoolByScore(String score, Integer schoolVariety, Integer majorVariety){
        if(score == null || "".equals(score)){
            Random rand = new Random();
            int scoreInt = 500 + Math.abs(rand.nextInt()%200);
            score = String.valueOf(scoreInt);
        }
        return R.success("schoolPush", schoolInfoService.querySchoolInfoByScore(new SchoolInfo(null, null, null,
                null, schoolVariety, null, null, null, majorVariety, score)));
    }
}
