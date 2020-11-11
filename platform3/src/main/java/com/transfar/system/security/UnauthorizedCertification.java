package com.transfar.system.security;

import com.transfar.system.utils.WebUtils;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/30 9:54
 * @Description: 未授权处理
 */
public class UnauthorizedCertification implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if(authException instanceof InsufficientAuthenticationException){
            WebUtils.sendErrorMessage(response,"请求被禁止，未提供凭证。");
        }else{
            WebUtils.sendErrorMessage(response,authException.getMessage());
        }
    }
}
