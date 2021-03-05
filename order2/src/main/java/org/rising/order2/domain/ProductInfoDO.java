package org.rising.order2.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 14:51
 * @Description:
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ProductInfoDO extends BaseDO{

    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private Double price;
    @Column(name = "stock")
    private int stock;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "picture_path")
    private String picturePath;
    @Column(name = "remark")
    private String remark;
}
