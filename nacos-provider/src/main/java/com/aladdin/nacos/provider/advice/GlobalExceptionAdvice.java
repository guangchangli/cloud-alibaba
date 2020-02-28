package com.aladdin.nacos.provider.advice;

import cn.hutool.core.util.StrUtil;
import com.aladdin.nacos.provider.common.Rest;
import com.google.common.collect.Lists;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionAdvice{

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Rest globalException(Exception e, HttpServletResponse response){
        Rest restfulMessage=new Rest();
        //参数校验未通过异常 @RequestBody参数校验失败
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            StringBuffer sb = new StringBuffer();
            List<String> errorArr= Lists.newArrayList();
            for (ObjectError error : errors) {
                if (error instanceof FieldError){
                    FieldError fieldError=(FieldError)error;
                    errorArr.add(fieldError.getField()+fieldError.getDefaultMessage());
                }else{
                    errorArr.add(error.getObjectName()+error.getDefaultMessage());
                }
            }
            String errMsg=StrUtil.join(";",errorArr.toArray(new String[]{}));
            restfulMessage.setErrCode(10400);
            restfulMessage.setMessage(errMsg);
        } else if (e instanceof ConstraintViolationException) {
            //@RequestParam 参数校验失败
            ConstraintViolationException exception = (ConstraintViolationException) e;
            StringBuffer sb = new StringBuffer();
            List<String> errorArr = Lists.newArrayList();
            for (ConstraintViolation constraint : exception.getConstraintViolations()) {
                errorArr.add(constraint.getInvalidValue() + "非法" + constraint.getMessage());
                //sb.append(constraint.getInvalidValue()).append("值不正确,").append(constraint.getMessage()).append(";");
            }
            restfulMessage.setErrCode(10400);
            restfulMessage.setMessage(StrUtil.join(";", errorArr.toArray(new String[]{})));
        }else{
            restfulMessage.setErrCode(10500);
            restfulMessage.setMessage(e.getMessage());
        }
        return restfulMessage;


    }
}