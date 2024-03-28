package org.example.youzhi.mapper;

import org.apache.ibatis.annotations.*;
import org.example.youzhi.pojo.SchoolInfo;

import java.util.List;

@Mapper
public interface SchoolInfoMapper {
    List<SchoolInfo> querySchoolInfo( @Param("pageIndex") int pageIndex,@Param("schoolInfo") SchoolInfo schoolInfo);

    @ResultMap("SchoolInfo")
    @Select("select * from schoolinfo where school_name = #{schoolName}")
    List<SchoolInfo> querySchoolInfoBySchoolName(String schoolName);

    @ResultMap("SchoolInfo")
    @Insert("insert schoolinfo (school_id, school_name, school_variety, major_id, major_name, year, major_variety, score_line)" +
            "values (#{schoolId}, #{schoolName}, #{schoolVariety}, #{majorId}, #{majorName}, #{year}, #{majorVariety}, #{scoreLine})")
    Integer addSchoolInfo(SchoolInfo schoolInfo);

    Integer querySchoolInfoCount(SchoolInfo schoolInfo);

    @ResultMap("SchoolInfo")
    @Select("select * from schoolinfo where major_name = #{majorName}")
    List<SchoolInfo> querySchoolInfoByMajorName(String majorName);

    List<SchoolInfo> querySchoolInfoByScore(@Param("scoreMax") String scoreMax, @Param("scoreMin") String scoreMin, Integer schoolVariety, Integer majorVariety);

    @Select("select distinct major_name from schoolinfo where school_name = #{schoolName} ")
    public List<String>queryMajorNameBySchoolName(String schoolName);

    @ResultMap("SchoolInfo")
    @Select("select * from schoolinfo where school_name = #{schoolName} and major_name = #{majorName}")
    public SchoolInfo querySchoolInfoByNames(@Param("schoolName") String schoolName,@Param("majorName") String MajorName);
}
