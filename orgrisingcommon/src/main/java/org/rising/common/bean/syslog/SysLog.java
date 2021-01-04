package org.rising.common.bean.syslog;

import lombok.Data;

import java.util.Date;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 11:10
 * @Description:系统日志实体类
 */
@Data
public class SysLog {

    private String sysName; //系统名称

    private String ip; //ip地址

    private String userId;//当前登录人

    private Date writeTime;//记录时间

    private String operation; //操作

    private String method; //方法名

    private String params; //参数

    private String resultParams;//结果参数

}
