/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.matcha.mall.common.controller;

import com.matcha.mall.common.utils.SysTenantUtils;
import com.matcha.mall.common.entity.SysTenantEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取当前租户信息
     *
     * @return
     */
    protected SysTenantEntity getLocalTenant() {
        return SysTenantUtils.get();
    }
}
