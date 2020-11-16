package org.rising.web.swagger;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.service.Contact;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/13 9:24
 * @Description:
 */
@Data
public class SwaggerBean {
    private String title = "接口测试文档";
    private String description= "测试";
    private String termsOfServiceUrl;
    private Contact contact;
    private String license;
    private String licenseUrl;
    private String version = "2.0";
}
