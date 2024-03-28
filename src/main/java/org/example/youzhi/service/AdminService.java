package org.example.youzhi.service;

import org.example.youzhi.pojo.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    List<Admin> queryAllAdmin();

    Admin queryAdminById(Integer Id);

    int addAdmin(Admin admin);

    int deleteAdminById(Integer id);

    int updateAdmin(Admin admin);

    Admin login(Admin admin);
}
