package org.rising.aop.syslog.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 15:37
 * @Description: 队列生产者
 */
public class ProducerImpl implements Producer{

    //案例
    public void sendDirectMessage(String exchangeName,String queueName,String routingKey,String message,Channel channel) throws IOException {
        channel.exchangeDeclare(exchangeName, "direct");
        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);
        channel.basicPublish("", queueName, null, message.getBytes());
    }

    @Override
    public void sendMessage(String exchangeName, String queueName, String routingKey, String message, Channel channel) throws IOException {
        channel.basicPublish(exchangeName, queueName, null, message.getBytes());
    }
}
