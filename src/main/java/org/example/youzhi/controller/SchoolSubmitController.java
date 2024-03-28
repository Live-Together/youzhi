package org.example.youzhi.controller;

import org.example.youzhi.pojo.SchoolSubmit;
import org.example.youzhi.service.SchoolSubmitService;
import org.example.youzhi.utils.R;
import org.example.youzhi.vo.SchoolSubmitCount;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SchoolSubmitController {

    @Resource
    private SchoolSubmitService schoolSubmitService;

//    @GetMapping("/getCount")
//    public R getCount(String schoolId, String majorId){
////        System.out.println(schoolId);
////        System.out.println(majorId);
//        return R.success("count", schoolSubmitService.getCount(schoolId, majorId));
//    }

    @GetMapping("/{id}/getSchoolSubmitById")
    public R getSchoolSubmitById(@PathVariable String id){
        return R.success("schoolSubmit", schoolSubmitService.querySchoolSubmitById(Integer.valueOf(id)));
    }

    @GetMapping("/getMajorNameBySchoolName")
    public R getMajorNameBySchoolName(String schoolName){
        List<String> majorNames = schoolSubmitService.queryMajorNameBySchoolName(schoolName);
        if(majorNames == null || majorNames.isEmpty()){
            return R.error();
        }
        return R.success("majorNames", majorNames);
    }

    @PostMapping("/{id}/schoolSubmit")
    public R schoolSubmit(@PathVariable String id, @RequestBody SchoolSubmit schoolSubmit){
        schoolSubmit.setStudentId(Integer.valueOf(id));
        List<SchoolSubmitCount> schoolSubmitCounts = schoolSubmitService.submitSchool(schoolSubmit);
        if(schoolSubmitCounts == null || schoolSubmitCounts.isEmpty()){
            return R.error();
        } else {
            return R.success("success", schoolSubmitCounts);
        }
    }

    @PostMapping("/deleteSchoolSubmit")
    public R deleteSchoolSubmit(@RequestBody SchoolSubmit schoolSubmit){
        schoolSubmitService.deleteSchoolSubmit(schoolSubmit);
        return R.success("delete", schoolSubmitService.querySchoolSubmitById(schoolSubmit.getStudentId()));
    }
}
