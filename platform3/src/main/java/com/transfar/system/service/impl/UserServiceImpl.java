package com.transfar.system.service.impl;

import com.transfar.system.dao.UserDao;
import com.transfar.system.dbBean.User;
import com.transfar.system.dto.login.LoginReturnData;
import com.transfar.system.dto.login.UserContextDto;
import com.transfar.system.exception.BusinessException;
import com.transfar.system.security.jwt.JwtUtil;
import com.transfar.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:29
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public LoginReturnData login(String userName, String pwd){
        User user = userDao.findByUserName(userName);
        if(user==null){
            throw new BusinessException("用户没有找到！");
        }else if (!user.getPassword().equals(pwd)){
            throw new BusinessException("密码不正确!");
        }else if(user.getDeleted()){
            throw new BusinessException("该用户已经被禁用!");
        }
        UserContextDto userContext = new UserContextDto();
        userContext.setUserName(userName);
        String token = JwtUtil.getToken(userContext);
        LoginReturnData loginReturnData = new LoginReturnData();
        loginReturnData.setUserName(userName);
        loginReturnData.setToken(token);
        return loginReturnData ;
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
