package org.example.youzhi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.youzhi.pojo.SchoolSubmit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSubmitCount {
    private Integer schoolId;
    private Integer studentId;
    private Integer majorId;
    private String majorName;
    private Integer majorVariety;
    private String schoolName;
    private Integer count;


    public SchoolSubmitCount(SchoolSubmit schoolSubmit, Integer count) {
        this.schoolId = schoolSubmit.getSchoolId();
        this.studentId = schoolSubmit.getStudentId();
        this.majorId = schoolSubmit.getMajorId();
        this.majorName = schoolSubmit.getMajorName();
        this.majorVariety = schoolSubmit.getMajorVariety();
        this.schoolName = schoolSubmit.getSchoolName();
        this.count = count;
    }
}
