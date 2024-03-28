package org.example.youzhi.mapper;

import org.apache.ibatis.annotations.*;
import org.example.youzhi.pojo.SchoolSubmit;

import java.util.List;

@Mapper
public interface SchoolSubmitMapper {

    @Results(id = "SchoolSubmit", value = {
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "student_id", property = "studentId"),
            @Result(column = "major_id", property = "majorId"),
            @Result(column = "major_name", property = "majorName"),
            @Result(column = "school_name", property = "schoolName"),
            @Result(column = "major_variety", property = "majorVariety")
    })
    @Select("select * from schoolsubmit where student_id = #{id}")
    public List<SchoolSubmit> querySchoolSubmitById(Integer id);

    @Insert("insert schoolsubmit(school_id, student_id, major_id, major_name, major_variety, school_name) " +
            "values(#{schoolId}, #{studentId}, #{majorId}, #{majorName}, #{majorVariety}, #{schoolName})")
    public Integer addSchoolSubmit(SchoolSubmit schoolSubmit);

    @Delete("delete from schoolsubmit where student_id = #{studentId} and school_id = #{schoolId} and major_id = #{majorId}")
    Integer deleteSchoolSubmit(SchoolSubmit schoolSubmit);

    @Select("select count(*) from schoolsubmit where school_id = #{schoolId} and major_id = #{majorId}")
    Integer getCount(@Param("schoolId") Integer schoolId,@Param("majorId") Integer majorId);
}
