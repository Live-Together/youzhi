package org.example.youzhi.service.impl;

import org.example.youzhi.mapper.AdminMapper;
import org.example.youzhi.pojo.Admin;
import org.example.youzhi.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryAllAdmin() {
        return adminMapper.queryAllAdmin();
    }

    @Override
    public Admin queryAdminById(Integer id) {
        return adminMapper.queryAdminById(id);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int deleteAdminById(Integer id) {
        return adminMapper.deleteAdminById(id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin login(Admin admin) {
        Integer adminId = admin.getAdminId();
        String password = admin.getPassword();
        Admin admin1 = adminMapper.queryAdminById(adminId);
        if(admin1 != null && password.equals(admin1.getPassword())){
            return admin1;
        } else {
            return null;
        }
    }


}
