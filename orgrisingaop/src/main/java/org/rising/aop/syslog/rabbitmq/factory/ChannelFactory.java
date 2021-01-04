package org.rising.aop.syslog.rabbitmq.factory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 16:40
 * @Description: 通道工厂
 * 在同一个连接下面产生一条新的通道
 */
public class ChannelFactory {

    private static Connection connection = new ConnFactory().getConn();
    public static Connection getConn(){
        return connection;
    }
    public Channel getChannel(){
        try {
            if (connection==null )return null;
            return connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
