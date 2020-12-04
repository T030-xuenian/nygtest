package org.rising.system.dbBean;

import org.rising.system.DBBaseBean;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.util.Date;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:04
 * @Description:
 */
@Data
@Entity(name = "tb_user")
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "created_date")
    private Date createDate;
}
