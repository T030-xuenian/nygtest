package org.rising.aop.syslog.rabbitmq.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.*;
/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 15:32
 * @Description: 队列配置信息
 */
@Data
public class MQConfig {
    public static final String SYSLOG_QUERY = "syslog.queue1";
//    syslogExchange

    private String host;
    private int port;
    private String username;
    private String password;
    private String virtualHost;
    private String queueName;
    private String exchangeName;
    private String routingKey;

    public static MQConfig getDefaultConfig(){
        MQConfig mqConfig = new MQConfig();
        mqConfig.setHost("127.0.0.1");
        mqConfig.setPort(5672);
        mqConfig.setUsername("root");
        mqConfig.setPassword("root");
        mqConfig.setVirtualHost("/");
        return mqConfig ;
    }

    @Bean
    public Queue syslogQueue(){
        return new Queue(SYSLOG_QUERY, true);
    }


}
