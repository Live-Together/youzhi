package org.example.youzhi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

  private Integer adminId;
  private String password;
  private String adminName;
  private String phone;
  private Integer status; //身份, 1代表管理员, 2代表学生

}
