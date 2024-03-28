package org.example.youzhi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.youzhi.pojo.SchoolShow;

import java.util.List;

@Mapper
public interface SchoolShowMapper {
    @Results(id = "SchoolShow", value = {
            @Result(column = "school_id", property = "schoolId"),
            @Result(column = "school_name", property = "schoolName"),
            @Result(column = "school_url", property = "schoolUrl"),
    })
    @Select("select * from schoolshow")
    List<SchoolShow> queryAll();
}
