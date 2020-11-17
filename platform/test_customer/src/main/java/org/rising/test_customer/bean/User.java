package org.rising.test_customer.bean;

import lombok.Data;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/16 16:24
 * @Description:
 */
@Data
public class User {
    private String id;
    private Boolean deleted = false;
    private String userName;
    private String password;
    private Integer userType;
    private String currentTenantId;
    private String personnelId;
}
