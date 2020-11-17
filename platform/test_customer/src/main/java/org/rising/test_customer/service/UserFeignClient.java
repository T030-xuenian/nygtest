package org.rising.test_customer.service;

import org.rising.web.utils.WebResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/17 9:08
 * @Description:
 */
@FeignClient("system")
public interface UserFeignClient {
    @PostMapping("/system/getAllUser")
    WebResult findAllUser();
}
