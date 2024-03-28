package org.example.youzhi.service.impl;

import org.example.youzhi.mapper.SchoolInfoMapper;
import org.example.youzhi.mapper.SchoolMapper;
import org.example.youzhi.pojo.SchoolInfo;
import org.example.youzhi.service.SchoolInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SchoolInfoServiceImpl implements SchoolInfoService {
    @Resource
    private SchoolInfoMapper schoolInfoMapper;

    @Resource
    private SchoolMapper schoolMapper;

    // 分页算法, 在该方法里处理传来的页码,将其转化为与数据库匹配的数字
    @Override
    public List<SchoolInfo> querySchoolInfo(int pageIndex, SchoolInfo schoolInfo) {
        return schoolInfoMapper.querySchoolInfo((pageIndex-1) * 10, schoolInfo);
    }

    @Override
    public Integer querySchoolInfoCount(SchoolInfo schoolInfo) {
        return schoolInfoMapper.querySchoolInfoCount(schoolInfo);
    }

    @Override
    public List<SchoolInfo> querySchoolInfoBySchoolName(String schoolName) {
        return schoolInfoMapper.querySchoolInfoBySchoolName(schoolName);
    }

    @Override
    public List<SchoolInfo> querySchoolInfoByMajorName(String majorName) {
        return schoolInfoMapper.querySchoolInfoByMajorName(majorName);
    }

    @Override
    public List<SchoolInfo> querySchoolInfoByScore(SchoolInfo schoolInfo) {
        List<SchoolInfo> schoolInfoList = schoolInfoMapper.querySchoolInfoByScore(String.valueOf(Integer.parseInt(schoolInfo.getScoreLine()) + 10),
                String.valueOf(Integer.parseInt(schoolInfo.getScoreLine()) - 10),
                schoolInfo.getSchoolVariety(),
                schoolInfo.getMajorVariety());
        if(schoolInfoList.size() > 4){
            List<SchoolInfo>sil = new LinkedList<>();
            Random rand = new Random();
            int start = Math.abs(rand.nextInt() % schoolInfoList.size());
            for(int i=0; i<4; i++, start++){
                sil.add(schoolInfoList.get(start%schoolInfoList.size()));
            }
            schoolInfoList = sil;
        }
        //从数据库取出所有数据,
        //从取出的数据中再取出四条进行展示
        //查询学校的logo
        for(SchoolInfo x : schoolInfoList){
            x.setLogo(schoolMapper.getSchoolLogoBySchoolName(x.getSchoolName()));
        }
        return schoolInfoList;
    }


}
