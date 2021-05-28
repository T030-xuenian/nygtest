package org.rising.system.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: xue nian
 * @DateTime: 2021/4/6 11:27
 * @Description:
 */
@Data
public class TestData {
    private Integer id;
    private String name;
    private String sex;
}
