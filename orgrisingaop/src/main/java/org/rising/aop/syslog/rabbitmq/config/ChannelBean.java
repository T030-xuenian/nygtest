package org.rising.aop.syslog.rabbitmq.config;

import lombok.Data;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/4 10:02
 * @Description:
 */
@Data
public class ChannelBean {
    private String exchangeName;
    private String queueName;
    private String routingKey;
}
