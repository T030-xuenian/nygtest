package org.rising.web.utils;

import lombok.Data;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/30 10:01
 * @Description:
 */
@Data
public class WebResult<T> {
    public WebResult(){}

    public WebResult(int code) {
        this.code = code;
    }
    public WebResult(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public WebResult(int code, String message,String type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }
    public WebResult(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
    public WebResult(int code,String type,String message,T result){
        this.code = code;
        this.message = message;
        this.result = result;
        this.type = type;
    }
    private int code ;
    private String type ="success";
    private String message;
    private T result;
}
