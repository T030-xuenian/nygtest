package org.rising.web.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/2 15:14
 * @Description: jwt帮助类
 */
public class JwtUtil {

    private static final String SECRET_KEY = "transfar_private_key";

    public static String getToken(UserContextDto userContext){
        long sysCurrentTimeMillis = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(userContext.getUserName()) //主题
                .setClaims(UserContextDto.passMap(userContext))
                .setIssuer("transfar") //发行者
                .setIssuedAt(new Date(sysCurrentTimeMillis)) //发行时间
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY) //设置加密方式
                .setExpiration(new Date(sysCurrentTimeMillis + 24 * 60 * 60 *  1000))//过期时间
                .compact();
        return token;
    }

    public static Claims parse(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }



}
