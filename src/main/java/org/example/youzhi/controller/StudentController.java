package org.example.youzhi.controller;

import org.example.youzhi.pojo.Student;
import org.example.youzhi.service.StudentService;
import org.example.youzhi.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/login")
    public R login(@RequestBody Student student){
        Student stu = studentService.queryStudentById(student.getStudentId());
        if(stu != null && stu.getPassword().equals(student.getPassword())){
            return R.success();
        }else {
            return R.error();
        }
    }

    @GetMapping("/{Id}")
    public R getStudentById(@PathVariable String Id){
        if(Id == null || "null".equals(Id))return R.error();
        return R.success("个人信息", studentService.queryStudentById(Integer.parseInt(Id)));
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
