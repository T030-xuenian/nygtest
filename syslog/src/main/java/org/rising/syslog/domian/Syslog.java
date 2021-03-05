package org.rising.syslog.domian;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 10:07
 * @Description:
 */
@Data
@Entity(name = "tb_syslog")
@EntityListeners(AuditingEntityListener.class)
public class Syslog {
    @Id
    @Column(name = "id")
    private int id;//编号
    @Column(name = "sys_name")
    private String sysName;//系统名称
    @Column(name = "ip")
    private String ip;//系统ip地址
    @Column(name = "user_id")
    private int userId;//登录人编号
    @Column(name = "write_time")
    private Date writeTime;//日志发送事件
    @Column(name = "operation")
    private String operation;//操作
    @Column(name = "method")
    private String method;//方法
    @Column(name = "params")
    private String params;//参数
    @Column(name = "resultParams")
    private String resultParams;//返回参数
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;//入库时间
}
