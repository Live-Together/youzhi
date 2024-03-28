package org.example.youzhi.service.impl;

import org.example.youzhi.mapper.SchoolInfoMapper;
import org.example.youzhi.mapper.SchoolSubmitMapper;
import org.example.youzhi.pojo.SchoolInfo;
import org.example.youzhi.pojo.SchoolSubmit;
import org.example.youzhi.service.SchoolSubmitService;
import org.example.youzhi.vo.SchoolSubmitCount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class SchoolSubmitServiceImpl implements SchoolSubmitService {

    @Resource
    private SchoolSubmitMapper schoolSubmitMapper;

    @Resource
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public List<SchoolSubmitCount> querySchoolSubmitById(Integer id) {
        List<SchoolSubmit> schoolSubmits = schoolSubmitMapper.querySchoolSubmitById(id);
        List<SchoolSubmitCount> schoolSubmitCounts = new LinkedList<SchoolSubmitCount>();
        for(SchoolSubmit schoolSubmit : schoolSubmits){
            Integer count = schoolSubmitMapper.getCount(schoolSubmit.getSchoolId(), schoolSubmit.getMajorId());
            SchoolSubmitCount schoolSubmitCount = new SchoolSubmitCount(schoolSubmit, count);
            schoolSubmitCounts.add(schoolSubmitCount);
        }
        return schoolSubmitCounts;
    }

    @Override
    public List<String> queryMajorNameBySchoolName(String schoolName) {
        return schoolInfoMapper.queryMajorNameBySchoolName(schoolName);
    }

    @Override
    public List<SchoolSubmitCount> submitSchool(SchoolSubmit schoolSubmit) {
        SchoolInfo schoolInfo = schoolInfoMapper.querySchoolInfoByNames(schoolSubmit.getSchoolName(), schoolSubmit.getMajorName());
        if(schoolSubmitMapper.addSchoolSubmit(schoolInfo.transferSchoolSubmit(schoolSubmit.getStudentId())) == 1){
            return querySchoolSubmitById(schoolSubmit.getStudentId());
        }
        return null;
    }

    @Override
    public Integer deleteSchoolSubmit(SchoolSubmit schoolSubmit) {
        return schoolSubmitMapper.deleteSchoolSubmit(schoolSubmit);
    }

//    @Override
//    public Integer getCount(String schoolId, String majorId) {
//        return schoolSubmitMapper.getCount(schoolId, majorId);
//    }
}
