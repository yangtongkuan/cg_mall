package com.matcha.mall.service.third.prv;

import com.matcha.mall.common.dto.SysTenantEntityDto;
import com.matcha.mall.common.service.SysTenantRemoteService;
import com.matcha.mall.entity.SysTenantEntity;
import com.matcha.mall.service.SysTenantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysTenantRemoteServiceImpl implements SysTenantRemoteService {

    @Autowired
    private SysTenantService sysTenantService;

    @Override
    public SysTenantEntityDto findSysTenantByTenantId(Long tenantId) {
        SysTenantEntity tenantEntity = sysTenantService.getById(tenantId);
        if (tenantEntity == null) {
            return null;
        }
        SysTenantEntityDto dto = new SysTenantEntityDto();
        BeanUtils.copyProperties(tenantEntity, dto);
        return dto;
    }
}
