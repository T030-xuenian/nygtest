package org.rising.system.swaager;

import org.rising.web.swagger.SwaggerBean;
import org.rising.web.swagger.SwaggerManage;
import org.springframework.stereotype.Component;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/13 11:06
 * @Description:
 */
@Component
public class SwaggerManageImpl implements SwaggerManage {
    @Override
    public SwaggerBean setSwaggerInfo() {
        SwaggerBean swaggerBean = new SwaggerBean();
        swaggerBean.setTitle("我是标题");
        swaggerBean.setVersion("我是Version");
        swaggerBean.setDescription("我是描述");
        return swaggerBean;
    }
}
