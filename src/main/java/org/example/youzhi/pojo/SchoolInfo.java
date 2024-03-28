package org.example.youzhi.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfo {

  private Integer id;
  private String logo;
  private Integer schoolId;
  private String schoolName;
  private Integer schoolVariety;   // 学校类别, 1代表985, 2代表211, 3代表普通一本, 4代表普通二本, 5代表专科院校
  private Integer majorId;
  private String majorName;
  private String year;
  private Integer majorVariety;  // 专业类别 1代表文科生可选, 2代表理科生可选, 3代表文/理科生都可选
  private String scoreLine;

  @Override
  public String toString() {
    return "SchoolInfo{" +
            "id=" + id +
            ", schoolId=" + schoolId +
            ", schoolName='" + schoolName + '\'' +
            ", schoolVariety=" + schoolVariety +
            ", majorId=" + majorId +
            ", majorName='" + majorName + '\'' +
            ", year='" + year + '\'' +
            ", majorVariety=" + majorVariety +
            ", scoreLine='" + scoreLine + '\'' +
            "}\n";
  }

  public SchoolSubmit transferSchoolSubmit(Integer studentId){
    return new SchoolSubmit(this.schoolId, studentId, this.majorId, this.majorName, this.majorVariety, this.schoolName);
  }
}
