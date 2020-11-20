package org.rising.zuul.service;

import org.rising.web.utils.WebResult;
import org.rising.zuul.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/20 8:49
 * @Description:
 */
@FeignClient("system")
public interface UserFeignClient {
    @PostMapping("/system/getAllUser")
    WebResult findAllUser();
    @PostMapping("/system/login")
    WebResult login(@RequestBody UserDto userDto);

}
