package org.rising.web.exception.handle;

import org.rising.web.exception.BusinessException;
import org.rising.web.utils.WebResult;
import org.rising.web.utils.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/6 10:02
 * @Description: 异常消息处理
 */
@Component
@ControllerAdvice
public class ExceptionHandle {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public WebResult handle(Exception e){
        if(e instanceof BusinessException){
            return WebUtils.businessExceptionError(e.getMessage());
        }
        e.printStackTrace();
        return WebUtils.error(e);
    }
}
