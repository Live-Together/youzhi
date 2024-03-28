package org.example.youzhi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolShow {

  private Integer schoolId;
  private String schoolName;
  private String logo;
  private String schoolUrl;


}
