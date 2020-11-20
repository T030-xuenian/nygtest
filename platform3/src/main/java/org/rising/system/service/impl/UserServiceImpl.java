package org.rising.system.service.impl;

import org.rising.system.dao.UserDao;
import org.rising.system.dbBean.User;
import org.rising.system.service.UserService;
import org.rising.web.exception.BusinessException;
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
    public User login(String userName, String pwd){
        User user = userDao.findByUserName(userName);
        if(user==null){
            throw new BusinessException("用户没有找到！");
        }else if (!user.getPassword().equals(pwd)){
            throw new BusinessException("密码不正确!");
        }else if(user.getDeleted()){
            throw new BusinessException("该用户已经被禁用!");
        }
        return user ;
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
