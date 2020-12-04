package org.rising.system.service;

import org.rising.system.dbBean.User;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:29
 * @Description:
 */
public interface UserService {
    User login(String userName, String pwd);
    User addUser(User baseBean);
}
