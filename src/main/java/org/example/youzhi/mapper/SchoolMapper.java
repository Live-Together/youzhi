package org.example.youzhi.mapper;

import org.apache.ibatis.annotations.*;
import org.example.youzhi.pojo.School;

import java.util.List;

@Mapper
public interface SchoolMapper {

    @Select("select logo from school where school_name = #{name}")
    String getSchoolLogoBySchoolName(String name);


    List<School> querySchoolBySchoolVariety(Integer schoolVariety);

    @ResultMap("School")
    @Select("select * from school")
    List<School> queryAll();

    @ResultMap("School")
    @Select("select * from school where school_name = #{name}")
    List<School> querySchoolById(String name);

    @Delete("delete from school where school_name = #{name} and school_id != #{id}")
    Integer deleteSchool(@Param("id") Integer id,@Param("name") String name);
}
