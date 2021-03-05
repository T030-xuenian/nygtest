package org.rising.syslog.dao;

import org.rising.syslog.domian.Syslog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 10:20
 * @Description:
 */
public interface SyslogDao extends JpaRepository<Syslog, Integer>, JpaSpecificationExecutor<Syslog> {

}
