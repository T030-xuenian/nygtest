package org.rising.test_customer.service;

import org.rising.test_customer.bean.TestData;
import org.rising.test_customer.bean.User;
import org.rising.web.utils.WebResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/17 9:08
 * @Description:
 */
@Service
@FeignClient("system")
public interface UserFeignClient {
    @PostMapping("/system/getAllUser")
    WebResult findAllUser();
    @PostMapping("/system/addUser")
    WebResult addUser(User user);
    @PostMapping("/system/addTest")
    WebResult addTest(TestData user);
}
