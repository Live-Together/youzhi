package org.example.youzhi.controller;

import org.example.youzhi.pojo.Student;
import org.example.youzhi.service.StudentService;
import org.example.youzhi.utils.R;
import org.example.youzhi.utils.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/login")
    public R login(@RequestBody Student student){
        Student stu = studentService.queryStudentById(student.getStudentId());
        if(stu != null && stu.getPassword().equals(student.getPassword())){
            String token = TokenUtil.sign(student);
            Map<String, Object>map = new HashMap<>();
            map.put("token", token);
            return R.success(map);
        }else {
            return R.error();
        }
    }

    @GetMapping("/getStudentInfo")
    public R getStudentInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer id = (Integer) TokenUtil.getTokenData(token).get("studentId");
        if(id == null)return R.error();
        return R.success("个人信息", studentService.queryStudentById(id));
    }

    @PostMapping("/updatePwd")
    public R updatePwd(@RequestBody Student student){
        if(studentService.updatePwd(student) == 1){
            return R.success();
        } else {
            return R.error();
        }
    }

    @PostMapping("/updateInfo")
    public R updateInfo(@RequestBody Student student) {
        if(studentService.updateStudent(student) == 1){
            return R.success();
        } else {
            return R.error();
        }
    }

}
