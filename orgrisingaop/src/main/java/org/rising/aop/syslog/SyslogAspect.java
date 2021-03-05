package org.rising.aop.syslog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.client.Channel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.rising.aop.syslog.rabbitmq.channel.SyslogSingleChannel;
import org.rising.aop.syslog.rabbitmq.config.MessageConfig;
import org.rising.aop.syslog.util.HttpContextUtils;
import org.rising.aop.syslog.util.IPUtils;
import org.rising.common.bean.syslog.SysLog;
import org.rising.common.utils.WebResult;
import org.rising.common.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 14:21
 * @Description:系统日志切面
 */
@Aspect
@Component
public class SyslogAspect {

    @Pointcut("@annotation(org.rising.aop.syslog.Syslog)")
    public void logPointCut(){
    }

    @AfterReturning(pointcut ="logPointCut()",returning = "webResult")
    public void saveSysLog(JoinPoint joinPoint, WebResult webResult) throws JsonProcessingException {
        SysLog sysLog = new SysLog();
        //TODO:系统名称 和登录人的Id号还未记录。
        sysLog.setWriteTime(new Date());//记录时间
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        Syslog log = method.getAnnotation(Syslog.class);
        if(log !=null)sysLog.setOperation(log.value());//操作
        String className = joinPoint.getTarget().getClass().getName();
        sysLog.setMethod(className+"."+methodName);//方法
        Object[] args = joinPoint.getArgs();
        String argsJson = WebUtils.toJson(args);
        sysLog.setParams(argsJson);//参数
        //获取用户ip地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        sysLog.setIp(IPUtils.getIpAddr(request));//记录ip
        sysLog.setResultParams("code:"+webResult.getCode()+",message:"+webResult.getMessage());//记录 代码以及 消息
        String message = WebUtils.toJson(sysLog);
        //向队列发送消息
        try {
            SyslogSingleChannel.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
