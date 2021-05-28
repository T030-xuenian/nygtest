package org.rising.system.dao;

import org.rising.system.dbBean.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:14
 * @Description:
 */
public interface TestDao extends JpaRepository<Test,Integer>, JpaSpecificationExecutor<Test>{

}
