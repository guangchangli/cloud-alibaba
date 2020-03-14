package com.aladdin.nacos.provider.entity.self;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author lgc
 **/
@Data
@Builder
@Validated
@TableName(value = "student")
public class Student {
    @NotNull
    @TableField
    private long id;
    @NotBlank
    @TableField
    private String name;
    @Range(min = 0,max = 2)
    @TableField
    private int sex;
    @TableField
    private String phone;
    @TableField
    private String address;
    @TableField
    private String create_time;
    @TableField
    private String modify_time;
    @TableField
    private BigDecimal money;
}
