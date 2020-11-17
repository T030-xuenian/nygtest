package org.rising.test_customer.utils;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xue nian
 * @DateTime: 2020/11/16 16:41
 * @Description:
 */
@Data
public class WebResult<T> {
    private int code;
    private String message;
    private List<T> data;
    public WebResult() {
    }

    public WebResult(int code) {
        this.code = code;
    }

    public WebResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public WebResult(int code, String message, List<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
