package org.rising.zuul.filter.jwt;

import org.rising.web.security.jwt.JwtIgnorePath;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/17 11:26
 * @Description:
 */
@Component
public class JwtIgnorePathImpl implements JwtIgnorePath {
    @Override
    public void add(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry) {
        expressionInterceptUrlRegistry.antMatchers("/**/swagger-resources/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/**/v2/api-docs",
                        "/**/configuration/ui",
                        "/**/configuration/security",
                        "/**/swagger-ui.html",
                        "/**/images/**",
                        "/**/webjars/**").permitAll();
    }
}
