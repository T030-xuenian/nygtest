package org.rising.system.dbBean;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: xue nian
 * @DateTime: 2021/4/6 11:29
 * @Description:
 */
@Data
@Entity(name = "tb_test")
public class Test {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
}
