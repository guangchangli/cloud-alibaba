package com.aladdin.nacos.provider.advice;

import com.aladdin.nacos.provider.common.CodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private CodeEnum code;
    private String remark;

    public BizException(CodeEnum code) {
        super(code.getMessage());
        this.code = code;
    }

    public BizException withRemark(String remark) {
        this.remark = remark;
        return this;
    }
}