package org.rising.order2.dao;

import org.rising.order2.domain.OrderDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 15:42
 * @Description:
 */
public interface OrderDetailDao extends JpaRepository<OrderDetailDO,Integer>, JpaSpecificationExecutor<OrderDetailDO> {


}
