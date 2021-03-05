package org.rising.order2.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 14:50
 * @Description:
 */
@Data
@Entity(name = "order_detail")
public class OrderDetailDO extends BaseDO{
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_count")
    private int productCount;
    @Column(name = "product_picture_path")
    private String productPicturePath;
}
