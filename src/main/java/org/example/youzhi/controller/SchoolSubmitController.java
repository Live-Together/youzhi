package org.example.youzhi.controller;

import org.example.youzhi.pojo.SchoolSubmit;
import org.example.youzhi.service.SchoolSubmitService;
import org.example.youzhi.utils.R;
import org.example.youzhi.utils.TokenUtil;
import org.example.youzhi.vo.SchoolSubmitCount;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/getSchoolSubmitById")
    public R getSchoolSubmitById(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer id = (Integer) TokenUtil.getTokenData(token).get("studentId");
        return R.success("schoolSubmit", schoolSubmitService.querySchoolSubmitById(id));
    }

    @GetMapping("/getMajorNameBySchoolName")
    public R getMajorNameBySchoolName(String schoolName){
        List<String> majorNames = schoolSubmitService.queryMajorNameBySchoolName(schoolName);
        if(majorNames == null || majorNames.isEmpty()){
            return R.error();
        }
        return R.success("majorNames", majorNames);
    }

    @PostMapping("/schoolSubmit")
    public R schoolSubmit(HttpServletRequest request, @RequestBody SchoolSubmit schoolSubmit){
        String token = request.getHeader("token");
        Integer id = (Integer) TokenUtil.getTokenData(token).get("studentId");
        schoolSubmit.setStudentId(id);
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
