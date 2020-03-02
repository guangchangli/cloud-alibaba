package com.aladdin.nacos.provider.entity.self;

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
    private long id;
    @NotBlank
    private String name;
    @Range(min = 0,max = 2)
    private int sex;
    private String phone;
    private String address;
    private String create_time;
    private String modify_time;
    private BigDecimal money;
}
