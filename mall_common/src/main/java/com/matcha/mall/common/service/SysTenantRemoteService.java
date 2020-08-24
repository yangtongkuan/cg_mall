package com.matcha.mall.common.service;

import com.matcha.mall.common.dto.SysTenantEntityDto;

public interface SysTenantRemoteService {
    SysTenantEntityDto findSysTenantByTenantId(Long tenantId);
}
