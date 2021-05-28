package org.rising.test_customer.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.rising.test_customer.bean.TestData;
import org.rising.test_customer.bean.User;
import org.rising.test_customer.service.UserFeignClient;
import org.rising.web.utils.WebResult;
import org.rising.web.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/11 8:55
 * @Description:
 */
@Api(value = "TestController",description = "测试事务")
@RestController("test")
public class TestController {
    @Autowired
    private UserFeignClient feignClient;

    @RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
    public WebResult helloConsumer() {
        return feignClient.findAllUser();
    }

    @ApiOperation("事务测试")
    @RequestMapping(value="testSave",method=RequestMethod.GET)
    public WebResult testSave() {
        TestData testData = new TestData();
        testData.setId(1);
        testData.setName("测试名称");
        testData.setSex("测试sex");
        User user = new User();
        user.setUserName("测试用户名称2");
        user.setPassword("123456");
        user.setUserType(9);
        feignClient.addUser(user);
        feignClient.addTest(testData);
        return WebUtils.success();
    }

}
