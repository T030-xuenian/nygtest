package com.transfar.system;

import lombok.Data;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: xue nian
 * @DateTime: 2020/10/29 11:08
 * @Description:
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@FilterDef(name = "notDeleted")
@Filters({
        @Filter(name = "notDeleted", condition = "is_deleted = 0")
})
public class DBBaseBean implements Serializable {
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted = false;
}
