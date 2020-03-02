package com.aladdin.nacos.provider.annotation;

import com.aladdin.nacos.provider.common.FillTypeEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JacksonFill {
    FillTypeEnum value() default FillTypeEnum.BRACE;
}