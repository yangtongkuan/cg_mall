package com.matcha.mall.common.utils;

import com.matcha.mall.common.api.ResultCode;
import com.matcha.mall.common.exception.MallCustomException;

/**
 * 自定义断言
 */
public class CgAssertUtils {

    /**
     * 判断是否为空对象
     *
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new MallCustomException(ResultCode.FAILED, message);
        }
    }

    /**
     * 判断字符传是否为空
     *
     * @param arg
     * @param message
     */
    public static void isEmpty(String arg, String message) {
        if (arg == null || arg.isEmpty()) {
            throw new MallCustomException(ResultCode.FAILED, message);
        }
    }
}
