package org.example.youzhi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class School {

  private Integer schoolId;
  private String schoolName;
  private Integer schoolVariety;
  private String logo;
  private String scoreSocial;
  private String scoreNatural;
}
