package org.rising.common.utils;

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
    public WebResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    private int code ;
    private String message;
    private T data;
}
