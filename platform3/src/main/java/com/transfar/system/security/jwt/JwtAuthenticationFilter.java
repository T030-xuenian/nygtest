package com.transfar.system.security.jwt;

import com.transfar.system.dto.login.UserContextDto;
import com.transfar.system.utils.WebUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/30 10:47
 * @Description: jwt 验证过滤器
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request,response);
            return;
        }
        try {
            Claims bearer = JwtUtil.parse(header.replace("Bearer ", ""));
            if(bearer == null){
                WebUtils.sendErrorMessage(response,"验证失败！");
                return;
            }
            UserContextDto userContext = UserContextDto.passUserContext(bearer);
            JwtAuthentication.authentication(userContext);
            chain.doFilter(request, response);
        }catch (ExpiredJwtException eje){
             WebUtils.sendMessage(response,8002,"登录已过期，请重新登录");
        }catch (Exception e){
            WebUtils.sendErrorMessage(response,"无效的凭证！请求失败！");
        }
    }

}
