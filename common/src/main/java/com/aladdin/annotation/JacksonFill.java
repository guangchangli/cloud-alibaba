package com.aladdin.annotation;


import com.aladdin.FillTypeEnum;

import java.lang.annotation.*;

/**
 * @author lgc
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface JacksonFill {
    FillTypeEnum value() default FillTypeEnum.BRACE;
}