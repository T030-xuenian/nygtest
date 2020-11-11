package com.transfar.system.dbBean;

import com.transfar.system.DBBaseBean;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:04
 * @Description:
 */
@Data
@Entity(name = "tb_user")
public class User extends DBBaseBean {

    @Column(name = "userName",unique=true,nullable = false , length = 100)
    private String userName;

    @Column(name = "password",nullable = false , length = 20)
    private String password;

    @Column(name = "user_type")
    private Integer userType;

    @Column(name = "current_tenant_id")
    private String currentTenantId;

    @Column(name = "personnel_id")
    private String personnelId;

}
