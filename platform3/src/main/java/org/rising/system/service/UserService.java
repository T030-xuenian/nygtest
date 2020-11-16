package org.rising.system.service;

import org.rising.system.dto.login.LoginReturnData;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:29
 * @Description:
 */
public interface UserService {
    LoginReturnData login(String userName, String pwd);
}
