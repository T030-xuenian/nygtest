package org.rising.zuul.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.rising.web.security.jwt.JwtUtil;
import org.rising.web.security.jwt.UserContextDto;
import org.rising.web.utils.WebResult;
import org.rising.web.utils.WebUtils;
import org.rising.zuul.dto.LoginReturnData;
import org.rising.zuul.dto.UserDto;
import org.rising.zuul.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/20 8:48
 * @Description:
 */
@Api(value = "系统消费者 ",description = "登录")
@RestController
public class SystemController {

    @Autowired
    private UserFeignClient feignClient;
    @ApiOperation("登录")
    @PostMapping("login")
    public WebResult login(@RequestBody UserDto userDto){
        WebResult login = feignClient.login(userDto);
        if(login.getCode()!=0) return login;
        Map map =(Map) login.getResult();
        UserContextDto userContextDto = new UserContextDto();
        userContextDto.setTokenKey("tokenKey");//TODO: 此处应该使用uuid 但是先写死 等用了redis之后 再完善
        userContextDto.setUserId(map.get("id").toString());
        userContextDto.setUserName(map.get("userName").toString());
        String token = JwtUtil.getToken(userContextDto);
        LoginReturnData loginReturnData =new LoginReturnData();
        loginReturnData.setToken(token);
        loginReturnData.setUserName(userContextDto.getUserName());
        return WebUtils.success(loginReturnData);
    }
    @ApiOperation("获取所有用户信息")
    @PostMapping("getAllUser")
    public WebResult getAllUser(){
        return feignClient.findAllUser();
    }


}
