package org.rising.web.security.jwt;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/30 17:28
 * @Description: 接口授权
 * 为所登录的用户授予能访问哪些接口的权限
 */
@Data
public class JwtAuthorities implements GrantedAuthority {

    private String code;
    private String name;
    private String url;
    private String type;

    @Override
    public String getAuthority() {
        return url;
    }
}
