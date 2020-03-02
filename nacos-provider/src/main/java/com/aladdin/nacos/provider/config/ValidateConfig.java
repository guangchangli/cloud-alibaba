package com.aladdin.nacos.provider.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidateConfig {

    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                //开启快速校验--默认校验所有参数，false校验全部
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }

    /**
     * @Null，标注的属性值必须为空
     *
     * @NotNull，标注的属性值不能为空
     *
     * @AssertTrue，标注的属性值必须为true
     *
     * @AssertFalse，标注的属性值必须为false
     *
     * @Min，标注的属性值不能小于min中指定的值
     *
     * @Max，标注的属性值不能大于max中指定的值
     *
     * @DecimalMin，小数值，同上
     *
     * @DecimalMax，小数值，同上
     *
     * @Negative，负数
     *
     * @NegativeOrZero，0或者负数
     *
     * @Positive，整数
     *
     * @PositiveOrZero，0或者整数
     *
     * @Size，指定字符串长度，注意是长度，有两个值，min以及max，用于指定最小以及最大长度
     *
     * @Digits，内容必须是数字
     *
     * @Past，时间必须是过去的时间
     *
     * @PastOrPresent，过去或者现在的时间
     *
     * @Future，将来的时间
     *
     * @FutureOrPresent，将来或者现在的时间
     *
     * @Pattern，用于指定一个正则表达式
     *
     * @NotEmpty，字符串内容非空
     *
     * @NotBlank，字符串内容非空且长度大于0
     *
     * @Email，邮箱
     *
     * @Range，用于指定数字，注意是数字的范围，有两个值，min以及max
     */
}
