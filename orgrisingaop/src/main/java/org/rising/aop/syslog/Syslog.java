package org.rising.aop.syslog;

import java.lang.annotation.*;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 14:27
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Syslog {
    String value() default "";
}
