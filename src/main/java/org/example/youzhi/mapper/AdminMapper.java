package org.example.youzhi.mapper;

import org.apache.ibatis.annotations.*;
import org.example.youzhi.pojo.Admin;

import java.util.List;

@Mapper
public interface AdminMapper{

    @Results(id="Admin", value={
            @Result(column = "admin_id", property = "adminId"),
            @Result(column = "admin_name", property = "adminName")
    })
    @Select("select * from admin")
    List<Admin> queryAllAdmin();

    @ResultMap("Admin")
    @Select("select * from admin where admin_id = #{id}")
    Admin queryAdminById(Integer id);

    @Insert("insert admin (admin_id, password, admin_name, phone, status) values" +
            " (#{adminId}, #{password}, #{adminName}, #{phone}, #{status})")

    int addAdmin(Admin admin);

    @Delete("delete from admin where admin_id = #{id}")
    int deleteAdminById(Integer id);

    @Update("update admin set password=#{password}, admin_name=#{adminName}, phone=#{phone}, status=#{status} where admin_id = #{adminId}")
    int updateAdmin(Admin admin);
}
