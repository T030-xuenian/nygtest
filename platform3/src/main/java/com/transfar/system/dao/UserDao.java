package com.transfar.system.dao;

import com.transfar.system.dbBean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:14
 * @Description:
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User>{
    User findByUserName(String userName);
}
