package org.rising.web.exception;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/2 17:24
 * @Description:
 */
public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
