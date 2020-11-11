package com.transfar.system.dto.login;

import lombok.Data;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/10 8:42
 * @Description: 登录之后返回给前台用的信息
 */
@Data
public class LoginReturnData {
    String userName;
    String token;
}
