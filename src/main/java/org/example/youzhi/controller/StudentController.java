package org.example.youzhi.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import org.apache.commons.lang3.StringUtils;
import org.example.youzhi.pojo.Student;
import org.example.youzhi.service.StudentService;
import org.example.youzhi.utils.R;
import org.example.youzhi.utils.TokenUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/login")
    public R login(@RequestBody Student student, HttpServletResponse response){
        String password = studentService.queryStudentById(student.getStudentId()).getPassword();
        if(password != null && youzhiDecoding(student.getPassword(), password)){
            String token = TokenUtil.sign(student);

            Cookie cookie = new Cookie("token", token);
            // 过期时间: 7天
            cookie.setMaxAge(60 * 60 * 24 * 7);
            /*
            * 这里将cookie路径设置为'/'
            * 是因为前端做了跨域代理,设置了一个跨域通配符'/api'
            * 如果没有设置cookie路径,前端就只有在'/api'的路径下才能使用该cookie
            * */
            cookie.setPath("/");
            response.addCookie(cookie);

            Map<String, Object>map = new HashMap<>();
            map.put("token", token);
            return R.success(map);

        }else {
            return R.error();
        }
    }

    @GetMapping("/getStudentInfo")
    public R getStudentInfo(HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println(token);
        Integer id = (Integer) TokenUtil.getTokenData(token).get("studentId");
        if(id == null)return R.error();
        return R.success("个人信息", studentService.queryStudentById(id));
    }

    @PostMapping("/updatePwd")
    public R updatePwd(@RequestBody Student student){
        String password = studentService.queryStudentById(student.getStudentId()).getPassword();
        if(youzhiDecoding(student.getPassword(), password)) {
            student.setPassword(youzhiEncoding(student.getNewPassword()));
            return R.toAjax(studentService.updateStudent(student) == 1);
        }
        return R.error("密码错误");
    }

    @PostMapping("/updateInfo")
    public R updateInfo(@RequestBody Student student) {
        return R.toAjax(studentService.updateStudent(student) == 1);
    }

    /*
    * md5加密思路
    * uuid + "$" + md5(uuid + 密码)
    * 此时长度为 32(uuid) + 1("$") + 32(md5加密字符串) = 65
    *  IdUtil.randomUUID() 生成UUID
    *  IdUtil.simpleUUID() 生成简便UUID（去掉-）
    *  IdUtil.fastUUID() 优化生成UUID
    *  IdUtil.fastSimpleUUID() 优化生成简便UUID
    * */
    public String youzhiEncoding(String str) {
        String salt = IdUtil.fastSimpleUUID();
        return salt + "$" + md5Encoding(str, salt);
    }

    public String md5Encoding(String str, String salt) {
        return SecureUtil.md5(salt + str);
    }

    /*
    * md5解密思路
    * 判断str是否为null或空字符串
    * 判断str长度是否为65位且是否含'$'
    * 将字符串按'$'前后分割,通过前32位获取盐值
    * 调用上面的加密方法进行加密 md5Encoding(pwd, salt)
    * 将加密后获得的字符串与目标字符串进行判等
    * */
    public Boolean youzhiDecoding(String pwd, String encodePwd) {
        if(StringUtils.isNotBlank(pwd) && StringUtils.isNotBlank(encodePwd)) {
            if(StringUtils.length(encodePwd) == 65 && StringUtils.contains(encodePwd, '$')) {
                // 分隔符一定要是\\$
                String[] arr = encodePwd.split("\\$");
                // arr[0] 盐值
                // arr[1] 加密后的密码
                return StringUtils.equals(md5Encoding(pwd, arr[0]), arr[1]);
            }
        }
        return false;
    }

}
