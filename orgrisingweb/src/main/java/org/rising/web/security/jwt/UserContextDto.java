package org.rising.web.security.jwt;

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
    private String userId;
    private String userName;
    private String tokenKey;
    public static Map<String,Object> passMap(UserContextDto userContextDto){
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userContextDto.getUserId());
        map.put("userName",userContextDto.getUserName());
        map.put("tokenKey",userContextDto.getTokenKey());
        return map;
    }
    public static UserContextDto passUserContext(Claims claims){
        UserContextDto userContext = new UserContextDto();
        userContext.setUserId((String)claims.get("userId"));
        userContext.setUserName((String)claims.get("userName"));
        userContext.setTokenKey((String)claims.get("tokenKey"));
        return userContext;
    }
}
