package org.rising.web.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang.StringUtils;
import org.rising.web.utils.WebUtils;
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
        //第一重验证
        //路由私密钥匙 该钥匙由路由派发 必须有该钥匙才能对保护资源进行访问
        //以后这个钥匙 走内网 由路由随机生成 储存在Nginx上面 在从这里读取出来做比对确保 该钥匙有路由生成
        //现在先这样写死 就叫 gateWay
//        String secretKey = request.getHeader("routePrivacy");
//        if(StringUtils.isBlank(secretKey)||!secretKey.equals("gateway")){
//            WebUtils.sendErrorMessage(response,"未提供资源访问钥匙！");
//            return;
//        }
        //第二重验证
        //在登录之后 会产生一个凭证 也就是 jwt 验证
        try {
            Claims bearer = JwtUtil.parse(header.replace("Bearer ", ""));
            if(bearer == null){
                WebUtils.sendErrorMessage(response,"验证失败！");
                return;
            }
            UserContextDto userContext = UserContextDto.passUserContext(bearer);
            //第三重验证
            // 每一个用户在 内网 Nginx 服务器 上面有一个 凭证钥匙 在每一次授权之后 我们都会更新这把钥匙
            // 通过对比钥匙 确保只有最新的凭证可以访问资源 也可以确保 jwt私密钥匙被破解或者泄露 凭证生成规则被解析 然后仿造凭证
            // 当用户退出登录的时候 应当在服务器上面清空这把钥匙 这样可以确保凭证失效！虽说凭证会自动过期过期。
            String tokenKey = userContext.getTokenKey();
            if(StringUtils.isBlank(tokenKey)||!tokenKey.equals("tokenKey")){
                WebUtils.sendErrorMessage(response,"该凭证非最新凭证！");
                return;
            }
            //TODO：授权 该授权没有做权限控制 后面一步一步完善
            JwtAuthentication.authentication(userContext);
            chain.doFilter(request, response);
        }catch (ExpiredJwtException eje){
             WebUtils.sendWarningMessage(response,8002,"授权已过期，请重新授权!");
        }catch (Exception e){
            WebUtils.sendErrorMessage(response,"无效的凭证！请求失败！");
        }
    }

}
