package com.matcha.mall.common.utils;

import com.matcha.mall.common.entity.SysTenantEntity;

/**
 * 租户工具类
 */
public class SysTenantUtils {

    private static ThreadLocal<SysTenantEntity> tenantInfoThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前请求的租户信息
     *
     * @param sysTenantInfo
     */
    public static void setLocalTenant(SysTenantEntity sysTenantInfo) {
        tenantInfoThreadLocal.set(sysTenantInfo);
    }

    /**
     * 删除当前租户信息
     */
    public static void remove() {
        tenantInfoThreadLocal.remove();
    }

    /**
     * 获取当前租户信息
     */
    public static SysTenantEntity get() {
        return tenantInfoThreadLocal.get();
    }

}
