package org.example.youzhi.service.impl;

import org.example.youzhi.mapper.SchoolShowMapper;
import org.example.youzhi.pojo.SchoolShow;
import org.example.youzhi.service.SchoolShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolShowServiceImpl implements SchoolShowService {

    @Resource
    private SchoolShowMapper schoolShowMapper;

    @Override
    public List<SchoolShow> queryAll() {
        return schoolShowMapper.queryAll();
    }
}
