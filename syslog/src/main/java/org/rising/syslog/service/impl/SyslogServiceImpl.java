package org.rising.syslog.service.impl;

import org.rising.syslog.dao.SyslogDao;
import org.rising.syslog.domian.Syslog;
import org.rising.syslog.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 10:26
 * @Description:
 */
@Service
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogDao syslogDao;
    @Override
    public void addOne(Syslog syslog) {
        syslogDao.save(syslog);
    }
}
