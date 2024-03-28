package org.example.youzhi.service;


import org.example.youzhi.mapper.SchoolInfoMapper;
import org.example.youzhi.pojo.SchoolInfo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public interface SchoolInfoService {

    List<SchoolInfo> querySchoolInfo(int pageIndex, SchoolInfo schoolInfo);

    Integer querySchoolInfoCount(SchoolInfo schoolInfo);

    List<SchoolInfo> querySchoolInfoBySchoolName(String schoolName);

    List<SchoolInfo> querySchoolInfoByMajorName(String majorName);

    List<SchoolInfo> querySchoolInfoByScore(SchoolInfo schoolInfo);
}
