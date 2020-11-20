package org.rising.web.security.jwt;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/17 11:20
 * @Description:
 */
public interface JwtIgnorePath {
    void add(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry);
}
