package org.rising.syslog.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.rising.common.utils.JsonHelper;
import org.rising.syslog.domian.Syslog;
import org.rising.syslog.service.SyslogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 9:54
 * @Description:
 */
@Service
public class MQReceiver {

    @Autowired
    private SyslogService service;

    @RabbitListener(queues = "syslog.queue1")
    public void receiverSyslog(String message){
        this.save(message);
        System.out.println(message);
    }
    @RabbitListener(queues = "syslog.queue2")
    public void receiverSyslog2(String message){
        this.save(message);
        System.out.println(message);
    }

    private void save(String message){
        try {
            Syslog syslog = JsonHelper.mapper.readValue(message, Syslog.class);
            service.addOne(syslog);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
