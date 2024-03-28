package org.example.youzhi.service;

import org.example.youzhi.pojo.SchoolSubmit;
import org.example.youzhi.vo.SchoolSubmitCount;

import java.util.List;

public interface SchoolSubmitService {
    List<SchoolSubmitCount> querySchoolSubmitById(Integer id);

    List<String> queryMajorNameBySchoolName(String schoolName);

    List<SchoolSubmitCount> submitSchool(SchoolSubmit schoolSubmit);

    Integer deleteSchoolSubmit(SchoolSubmit schoolSubmit);

//    Integer getCount(Integer schoolId, Integer majorId);
}
