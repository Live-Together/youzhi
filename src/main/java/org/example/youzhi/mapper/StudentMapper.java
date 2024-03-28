package org.example.youzhi.mapper;

import org.apache.ibatis.annotations.*;
import org.example.youzhi.pojo.Student;

@Mapper
public interface StudentMapper {

    @Results(id = "Student", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
    })
    @Select("select * from student where student_id = #{id}")
    Student queryStudentById(Integer id);

    @ResultMap("Student")
    @Update("update student set student_name = #{studentName} ,subject = #{subject} ,score = #{score} ,username = #{username} where student_id = #{studentId}")
    Integer updateStudent(Student student);
}
