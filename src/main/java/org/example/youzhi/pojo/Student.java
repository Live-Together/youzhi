package org.example.youzhi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

  private Integer studentId;
  private String username;
  private String password;
  private String studentName;
  private String score;
  private Integer subject;

}
