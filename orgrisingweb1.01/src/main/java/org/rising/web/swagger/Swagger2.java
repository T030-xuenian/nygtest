package org.rising.web.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 10:19
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Autowired(required=false)
    private SwaggerManage swaggerManage;
    @Bean
    public Docket createRestApi(){
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization")
                .description("Token")
                .modelRef(new ModelRef("string"))
                .defaultValue("Bearer ")
                .parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        SwaggerBean swagger = new SwaggerBean();
        if (swaggerManage!=null)
            swagger = swaggerManage.setSwaggerInfo();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo(swagger));
    }

    private ApiInfo apiInfo(SwaggerBean swaggerBean) {
        return new ApiInfoBuilder()
                .title(swaggerBean.getTitle())
//                .contact(new Contact("123","456","789"))
                .description(swaggerBean.getDescription())
                .version(swaggerBean.getVersion())
                .build();
    }

}
