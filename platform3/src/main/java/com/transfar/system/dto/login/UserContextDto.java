package com.transfar.system.dto.login;

import io.jsonwebtoken.Claims;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/6 14:42
 * @Description:
 */
@Data
public class UserContextDto {
    private String userName;
    public static Map<String,Object> passMap(UserContextDto userContextDto){
        Map<String,Object> map = new HashMap<>();
        map.put("userName",userContextDto.getUserName());
        return map;
    }
    public static UserContextDto passUserContext(Claims claims){
        UserContextDto userContext = new UserContextDto();
        userContext.setUserName((String)claims.get("userName"));
        return userContext;
    }
}
