package com.matcha.mall.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matcha.mall.common.api.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局同意处理返回格式问题
 */
@RestControllerAdvice(basePackages = {"com.matcha.mall.controller"})
@Slf4j
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        /**
         * 如果接口本来就返回这个对象,那么就不会在进行处理了
         */

        log.info("1---->" + CommonResult.class);
        log.info("2---->" + methodParameter.getNestedParameterType());
        return !methodParameter.getNestedParameterType().equals(CommonResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getGenericParameterType().equals(String.class)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(CommonResult.success(data));
            } catch (Exception e) {
                e.printStackTrace();
                return data;
            }
        }
        return CommonResult.success(data);
    }
}
