package org.example.youzhi.service.impl;

import org.example.youzhi.mapper.SchoolMapper;
import org.example.youzhi.pojo.School;
import org.example.youzhi.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;
    @Override
    public List<School> querySchoolBySchoolVariety(Integer schoolVariety) {
        return schoolMapper.querySchoolBySchoolVariety(schoolVariety);
    }
}
