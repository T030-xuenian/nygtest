package org.rising.aop.syslog.rabbitmq.factory;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.rising.aop.syslog.rabbitmq.config.MQConfig;
import org.rising.aop.syslog.rabbitmq.config.MessageConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/23 15:02
 * @Description: 产生一条新的连接
 */
public class ConnFactory {

    @Autowired(required = false)
    private MessageConfig messageConfig;

    public Connection getConn(){
        ConnectionFactory factory = new ConnectionFactory();
        MQConfig mqConfig= null ;
        if(messageConfig!=null)mqConfig = messageConfig.getConfig();
        else mqConfig = MQConfig.getDefaultConfig();
        factory.setHost(mqConfig.getHost());
        factory.setPort(mqConfig.getPort());
        factory.setUsername(mqConfig.getUsername());
        factory.setPassword(mqConfig.getPassword());
        factory.setVirtualHost(mqConfig.getVirtualHost());
        try {
            return factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

}
