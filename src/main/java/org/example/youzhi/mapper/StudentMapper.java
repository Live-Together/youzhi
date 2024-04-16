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
    @Update("<script>" +
            "UPDATE student " +
            "<set>" +
            "<if test='studentName != null and studentName != \"\"'>" +
            " , student_name = #{studentName} " +
            "</if>" +
            "<if test='subject != null and subject != \"\"'>" +
            " , subject = #{subject} " +
            "</if>" +
            "<if test='score != null and score != \"\"'>" +
            " , score = #{score} " +
            "</if>" +
            "<if test='username != null and username != \"\"'>" +
            " , username = #{username} " +
            "</if>" +
            "<if test='password != null and password != \"\"'>" +
            " , password = #{password} " +
            "</if>" +
            "</set>" +
            " WHERE student_id = #{studentId} " +
            "</script>")
    Integer updateStudent(Student student);
}
