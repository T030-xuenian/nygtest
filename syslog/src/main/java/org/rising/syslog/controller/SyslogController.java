package org.rising.syslog.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 10:34
 * @Description:
 */
@RestController
@RequestMapping("syslog")
@Api(value = "日志模块",description = "日志查询接口")
public class SyslogController {

}
