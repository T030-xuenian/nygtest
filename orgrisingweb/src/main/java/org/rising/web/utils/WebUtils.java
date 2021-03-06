package org.rising.web.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/30 9:59
 * @Description:
 */
public class WebUtils {


    private static final int ERROR_CODE = -1;
    private static final int SUCCESS_CODE = 0;
    private static final String DEFAULT_SUCCESS_MESSAGE = "success";
    private static final int BUSINESS_EXCEPTION_ERROR_CODE = 100;
    private static final String DEFAULT_ERROR_TYPE = "error";
    private static final  String DEFAULT_WARNING_TYPE = "warning";

    /**
     * json 格式转换
     * */
    public static String toJson(Object value) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(value);
    }

    /**
     *  返回异常消息
     * */
    public static WebResult error(Exception e){
        return new WebResult(e.hashCode(),e.getMessage(),DEFAULT_ERROR_TYPE);
    }

    /**
     * 返回错误消息
     * */
    public static WebResult error(String message){
        return new WebResult(ERROR_CODE,message,DEFAULT_ERROR_TYPE);
    }
    //返回 业务异常消息
    public static WebResult businessExceptionError(String message){
        return new WebResult(BUSINESS_EXCEPTION_ERROR_CODE,message,DEFAULT_ERROR_TYPE);
    }

    /**
     * 成功 默认消息 无返回数据
     * */
    public static WebResult success(){
        return new WebResult(SUCCESS_CODE,DEFAULT_SUCCESS_MESSAGE);
    }
    /**
     * 成功且返回数据
     * */
    public static WebResult success(Object data){
        return new WebResult(SUCCESS_CODE,DEFAULT_SUCCESS_MESSAGE,data);
    }
    /**
     * 成功且返回数据且自定义消息
     * */
    public static WebResult success(Object data, String message){
        return new WebResult(SUCCESS_CODE,message,data);
    }
    /**
     * 返回 其他消息
     * */
    public static WebResult resultMessage(int code, String message, String type){
        return new WebResult(code,message,type);
    }
    /**
     * 发送错误的消息 错误，禁止、无权限 消息统一定义为 -1
     * */
    public static void sendErrorMessage(HttpServletResponse response,String message) throws IOException {
        sendMessage(response,ERROR_CODE,message,DEFAULT_ERROR_TYPE);
    }
    /**
     * 发送警告消息
     * */
    public static void sendWarningMessage(HttpServletResponse response,int code,String message) throws IOException {
        sendMessage(response,code,message,DEFAULT_WARNING_TYPE);
    }

    /**
     * 发送消息
     * */
    public static void sendMessage(HttpServletResponse response, int code, String message,String type) throws IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setDateHeader("Expires", 0);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        WebResult result = WebUtils.resultMessage(code,message,type);
        response.getWriter().write(WebUtils.toJson(result));
    }

}
