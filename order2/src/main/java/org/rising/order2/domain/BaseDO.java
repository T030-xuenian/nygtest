package org.rising.order2.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author: xue nian
 * @DateTime: 2021/1/8 14:53
 * @Description:
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class BaseDO implements Serializable {
    @Id
    @Column(name = "id")
    private int id;
}
