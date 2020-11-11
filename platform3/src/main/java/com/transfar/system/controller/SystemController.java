package com.transfar.system.controller;

import com.transfar.system.dbBean.User;
import com.transfar.system.dto.login.LoginReturnData;
import com.transfar.system.dto.login.UserDto;
import com.transfar.system.exception.BusinessException;
import com.transfar.system.service.impl.UserServiceImpl;
import com.transfar.system.utils.WebResult;
import com.transfar.system.utils.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:32
 * @Description:
 */
@RestController
@Api(value = "系统模块",description = "系统基本功能")
@RequestMapping("system")
public class SystemController{

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "登陆")
    @PostMapping("login")
    public WebResult<User> login(@RequestBody UserDto userDto) throws BusinessException{
        LoginReturnData login = userService.login(userDto.getUserName(), userDto.getPassword());
        return WebUtils.success(login);
    }

    @ApiOperation(value = "查询所有用户测试用的")
    @RequestMapping("getAllUser")
    public WebResult<User> findAll() throws BusinessException {
        List<User> all = userService.findAll();
        return WebUtils.success(all);
    }

}
