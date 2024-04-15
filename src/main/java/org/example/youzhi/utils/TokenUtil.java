package org.example.youzhi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.example.youzhi.pojo.Admin;
import org.example.youzhi.pojo.Student;

import java.util.Date;

public class TokenUtil {
    private static final long EXPIRE_TIME = 1000*60*60;
    private static final String TOKEN_SECRET = "test";

    /**
     * 签名生成
     */
    public static String sign(Student user) {
        String token = null;
        try{
           Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
           token = JWT.create()
                   .withIssuer("auth0")  //发行人
                   .withClaim("username", user.getStudentId())
                   .withExpiresAt(expiresAt)  //过期时间
                   .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return token;
    }
}
