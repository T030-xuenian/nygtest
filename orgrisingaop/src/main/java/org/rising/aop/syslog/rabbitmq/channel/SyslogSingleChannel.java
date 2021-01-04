package org.rising.aop.syslog.rabbitmq.channel;

import com.rabbitmq.client.Channel;
import org.rising.aop.syslog.rabbitmq.factory.ChannelFactory;
import org.rising.aop.syslog.rabbitmq.producer.Producer;

import java.io.IOException;

/**
 * @Author: xue nian
 * @DateTime: 2020/12/22 15:44
 * @Description: 日志持久化通道
 */
public class SyslogSingleChannel {

    private static Channel channel =  new ChannelFactory().getChannel();

    public static Channel getChannel(){
        return channel;
    }

    public static void sendMessage( String message) throws IOException {
        channel.basicPublish("syslogExchange", "syslogRoutingKey", null, message.getBytes());
    }

}
