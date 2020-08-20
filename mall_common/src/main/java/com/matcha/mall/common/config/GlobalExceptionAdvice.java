package com.matcha.mall.common.config;

import com.matcha.mall.common.api.CommonResult;
import com.matcha.mall.common.api.ResultCode;
import com.matcha.mall.common.exception.MallCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理类
 */
@RestControllerAdvice(basePackages = "com.matcha.mall.controller")
@Slf4j
public class GlobalExceptionAdvice {

    /**
     * 全局自定义异常
     *
     * @param exception
     * @return CommonResult
     */
    @ExceptionHandler(MallCustomException.class)
    public CommonResult handleMallCustomException(MallCustomException exception) {
        log.error("全局自定义异常---->{}", exception.getMessage());
        return CommonResult.failed(exception.getCode() == null ? ResultCode.FAILED.getCode() : exception.getCode(), exception.getMessage());
    }

    /**
     * jsr 303 入参校验异常
     *
     * @param e
     * @return CommonResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();

        if (result.hasErrors()) {
            result.getFieldErrors().forEach(item -> {
                //FieldError 获取到错误提示
                String message = item.getDefaultMessage();
                //获取错误的属性的名字
                String field = item.getField();
                errorMap.put(field, message);
                log.error(field + ":" + message);
            });
        }
        log.error("参数请求异常 ---->{}", errorMap);
        return CommonResult.failed().setData(errorMap).setMessage(errorMap.get(errorMap.keySet().iterator().next()));
    }

    /**
     * 自定义其他的异常信息
     *
     * @param exception
     * @return  CommonResult
     */
    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception exception) {
        log.error("其他异常 ---->{}", exception.getMessage());
        return CommonResult.failed(exception.getMessage());
    }

}
