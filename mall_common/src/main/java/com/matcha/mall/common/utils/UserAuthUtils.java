package com.matcha.mall.common.utils;

import com.matcha.mall.common.dto.UserInfoDto;

/**
 * 租户工具类
 */
public class UserAuthUtils {

    private static ThreadLocal<UserInfoDto> UserInfoDtoThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前请求的用户信息
     *
     * @param userInfoDto
     */
    public static void setLocalTenant(UserInfoDto userInfoDto) {
        UserInfoDtoThreadLocal.set(userInfoDto);
    }

    /**
     * 删除当前的用户请求信息
     */
    public static void remove() {
        UserInfoDtoThreadLocal.remove();
    }

    /**
     * 获取当前用户信息
     */
    public static UserInfoDto get() {
        return UserInfoDtoThreadLocal.get();
    }

}
