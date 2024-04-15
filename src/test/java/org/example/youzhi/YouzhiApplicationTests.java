package org.example.youzhi;

import org.example.youzhi.mapper.SchoolInfoMapper;
import org.example.youzhi.mapper.SchoolMapper;
import org.example.youzhi.pojo.Admin;
import org.example.youzhi.pojo.School;
import org.example.youzhi.pojo.SchoolInfo;
import org.example.youzhi.pojo.Student;
import org.example.youzhi.service.AdminService;
import org.example.youzhi.service.SchoolInfoService;
import org.example.youzhi.service.SchoolSubmitService;
import org.example.youzhi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.*;

@SpringBootTest
class YouzhiApplicationTests {

    @Resource
    private AdminService adminService;

    @Resource
    private SchoolInfoMapper schoolInfoMapper;

    @Resource
    private SchoolMapper schoolMapper;

    @Resource
    private SchoolInfoService schoolInfoService;

    @Resource
    private StudentService studentService;

    @Resource
    private SchoolSubmitService schoolSubmitService;

    @Test
    void edit(){
//        for(School school : schools){
//            schoolMapper.deleteSchool(school.getSchoolId(), school.getSchoolName());
//        }
        while(true){
            boolean flag = false;
            List<School> schools = schoolMapper.queryAll();
            for(School school: schools){
                List<School> schools1 = schoolMapper.querySchoolById(school.getSchoolName());
                if(schools1.size() > 1){
                    schoolMapper.deleteSchool(school.getSchoolId(), school.getSchoolName());
                    flag = true;
                    break;
                }
            }
            if(!flag)break;
        }
    }

    @Test
    void testQuerySchoolSubmitById(){
        System.out.println(schoolSubmitService.querySchoolSubmitById(1));
    }

    @Test
    void testQuerySchoolInfoByNames(){
        System.out.println(schoolInfoMapper.querySchoolInfoByNames("江西师范大学", "软件工程"));
    }

    @Test
    void testQueryMajorNameBySchoolName(){
        System.out.println(schoolSubmitService.queryMajorNameBySchoolName("江西师范大学"));
    }

    @Test
    void testSchoolSubmit(){
        System.out.println(schoolSubmitService.querySchoolSubmitById(1));
    }

    @Test
    void testUpdateStudent(){
        studentService.updateStudent(new Student(1, "username_03", null, "stu_03", "601", 1));
    }

    @Test
    void testQuerySchoolBySchoolVariety(){
        System.out.println(schoolMapper.querySchoolBySchoolVariety(1));
    }


    @Test
    void testQuerySchoolInfoByScore(){
        List<SchoolInfo> schoolInfos = schoolInfoService.querySchoolInfoByScore(new SchoolInfo(null, null, null,
                null, null, null, null, null, null, "535"));
        System.out.println(schoolInfos);

    }

    @Test
    void testQuerySchoolInfo() throws UnsupportedEncodingException {
        int pageIndex = 1;
        SchoolInfo schoolInfo = new SchoolInfo(null, null, null, "江西师范大学", null, null,"", null, null, null);
        System.out.println(schoolInfoService.querySchoolInfo(pageIndex, schoolInfo));

        List<SchoolInfo> schoolInfoList = schoolInfoService.querySchoolInfo(pageIndex, schoolInfo);
        List<SchoolInfo> sil = new LinkedList<>();
        Random rand = new Random();
        int start = Math.abs(rand.nextInt() % schoolInfoList.size());
        for(int i=0; i<4; i++, start++){
            System.out.println(start);
            System.out.println(start%schoolInfoList.size());
            sil.add(schoolInfoList.get(start%schoolInfoList.size()));
        }
        System.out.println(sil);
//        System.out.println(Integer.valueOf(""));
    }

    @Test
    void testQuerySchoolInfoCount(){
        SchoolInfo schoolInfo = new SchoolInfo(null, null, null, "江西师范大学", null, null, null, null, null, null);
        System.out.println(schoolInfoService.querySchoolInfoCount(schoolInfo));
    }



    @Test
    void testAddSchoolInfo(){
        SchoolInfo schoolInfo = new SchoolInfo(null, null, 100011, "北京大学",1, 80901, "计算机科学与技术", "2022", 1, "671");
        for(int i=0; i<10; i++){
            schoolInfoMapper.addSchoolInfo(schoolInfo);
        }
    }

    @Test
    void testQuerySchoolInfoBySchoolName(){
        System.out.println(schoolInfoMapper.querySchoolInfoBySchoolName("江西师范大学"));
    }



    @Test
    void testUpdateAdmin(){
        Admin admin = new Admin(3, "13322", "admin_03","123123"  , 0);
        adminService.updateAdmin(admin);
        System.out.println(adminService.queryAdminById(3));
    }

    @Test
    void testDeleteAdminById() throws Exception {
        if (adminService.deleteAdminById(3) != 0) {
            System.out.println(adminService.queryAllAdmin());
        } else {
            throw(new Exception("插入失败----------------------------------------------"));
        }
    }

    @Test
    void testAddAdmin() throws Exception {
        Admin admin = new Admin(null, "12233", "admin_03", "123321", 0);
        if (adminService.addAdmin(admin) != 0) {
            System.out.println(adminService.queryAllAdmin());
        } else {
                throw(new Exception("插入失败----------------------------------------------"));
        }
    }

    @Test
    void testQueryAdminById(){
        System.out.println(adminService.queryAdminById(2));
    }

    @Test
    void testQueryAllAdmin(){
        System.out.println(adminService.queryAllAdmin());
    }

    @Test
    void contextLoads() {
        System.out.println(new Date(System.currentTimeMillis() + 60*1000));
    }

}
