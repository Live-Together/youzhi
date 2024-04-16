package org.example.youzhi.service;

import org.example.youzhi.pojo.Student;


public interface StudentService {


    public Student queryStudentById(Integer id);

    public Integer updateStudent(Student student);

    public Integer updatePwd(Student student);
}
