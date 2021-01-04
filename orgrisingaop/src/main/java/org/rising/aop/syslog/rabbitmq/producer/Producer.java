package org.rising.aop.syslog.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/23 10:41
 * @Description:
 */
public interface Producer {
    void sendMessage(String exchangeName, String queueName, String routingKey, String message, Channel channel) throws IOException;
}
