package com.matcha.mall.common.service;

import com.matcha.mall.common.entity.SysTenantEntity;

public interface SysTenantService {
    default SysTenantEntity findSysTenantByTenantId(Long tenantId) {
        if (tenantId != null) {
            return new SysTenantEntity();
        }
        return null;
    }
}
