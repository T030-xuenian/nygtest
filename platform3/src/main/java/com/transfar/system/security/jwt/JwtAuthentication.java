package com.transfar.system.security.jwt;

import com.transfar.system.dto.login.UserContextDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/6 9:12
 * @Description: 对登录用户授予可访问接口的权限
 * 暂时没有对接口做权限控制 也就是可以访问后台所有接口
 */
public class JwtAuthentication {

    public static void authentication(UserContextDto userContext){
        List<JwtAuthorities> list = new ArrayList<>();
        JwtAuthorities jwtAuthorities = new JwtAuthorities();
        list.add(jwtAuthorities);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userContext, null, list);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
