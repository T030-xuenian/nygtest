package org.rising.order2.domain;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.util.Date;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 14:50
 * @Description:
 */
@Data
@Entity(name = "order_master")
@EntityListeners(AuditingEntityListener.class)
public class OrderMasterDO extends BaseDO{
    @Column(name = "buyer_name")
    private String buyerName;
    @Column(name = "buyer_phone")
    private String buyerPhone;
    @Column(name = "buyer_address")
    private String buyerAddress;
    @Column(name = "order_status")
    private int orderStatus;
    @Column(name = "payment_status")
    private int paymentStatus;
    @Column(name = "total_money")
    private Double totalMoney;
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;
    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;
}
