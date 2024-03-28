package org.example.youzhi.service;

import org.example.youzhi.pojo.School;

import java.util.List;

public interface SchoolService {
    List<School> querySchoolBySchoolVariety(Integer schoolVariety);
}
