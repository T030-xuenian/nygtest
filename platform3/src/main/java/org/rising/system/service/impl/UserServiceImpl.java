package org.rising.system.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.rising.system.dao.TestDao;
import org.rising.system.dao.UserDao;
import org.rising.system.dbBean.Test;
import org.rising.system.dbBean.User;
import org.rising.system.dto.TestData;
import org.rising.system.service.UserService;
import org.rising.web.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private TestDao testDao;
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

    @LcnTransaction
    @Transactional
    @Override
    public User addUser(User user) {
        user.setCurrentTenantId("8b9703d4-5a2b-4b8a-a508-b55833563c8b");
        user.setPersonnelId("01b9df16-ae9a-4133-8005-56e59a33fb60");
        return userDao.save(user);
    }
    @LcnTransaction
    @Transactional
    @Override
    public Test addTestData(TestData testData) {
        Test test = new Test();
        test.setId(testData.getId());
        test.setName(testData.getName());
        test.setSex(testData.getSex());
        return testDao.save(test);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
