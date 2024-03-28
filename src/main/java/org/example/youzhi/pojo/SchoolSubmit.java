package org.example.youzhi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSubmit {

  private Integer schoolId;
  private Integer studentId;
  private Integer majorId;
  private String majorName;
  private Integer majorVariety;
  private String schoolName;

  public String toString(Integer count) {
    return "SchoolSubmit{" +
            "schoolId=" + schoolId +
            ", studentId=" + studentId +
            ", count=" + count +
            ", majorId=" + majorId +
            ", majorName='" + majorName + '\'' +
            ", majorVariety=" + majorVariety +
            ", schoolName='" + schoolName + '\'' +
            '}';
  }
}
