package org.example.youzhi.service.impl;

import org.example.youzhi.mapper.StudentMapper;
import org.example.youzhi.pojo.Student;
import org.example.youzhi.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.queryStudentById(id);
    }

    @Override
    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}
