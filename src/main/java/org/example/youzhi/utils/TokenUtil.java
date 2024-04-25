package org.example.youzhi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.youzhi.pojo.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.example.youzhi.constant.TokenConstant.EXPIRE_TIME;
import static org.example.youzhi.constant.TokenConstant.TOKEN_SALT;

public class TokenUtil {
    /**
     * 签名生成
     */
    public static String sign(Student user) {
        String token = null;
        try{
           Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
           token = JWT.create()
                   .withIssuer("auth0")  //发行人
                   .withClaim("studentId", user.getStudentId())
                   .withExpiresAt(expiresAt)  //过期时间
                   .sign(Algorithm.HMAC256(TOKEN_SALT));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return token;
    }

    public static boolean verity(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SALT)).build();
            verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static Map<String, Object> getTokenData(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SALT)).build();
            DecodedJWT jwt = verifier.verify(token);
            HashMap<String, Object> map = new HashMap<>();
            map.put("studentId",jwt.getClaim("studentId").asInt());
            map.put("expiresDate", jwt.getExpiresAt());
            return map;
        } catch (Exception e){
            return null;
        }
    }
}
