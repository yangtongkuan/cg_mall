package com.matcha.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matcha.mall.common.entity.SysTenantEntity;
import com.matcha.mall.common.service.SysTenantService;
import com.matcha.mall.dao.SysTenantDao;
import org.springframework.stereotype.Service;

@Service("sysTenantService")
public class SysTenantServiceImpl extends ServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {

    @Override
    public SysTenantEntity findSysTenantByTenantId(Long tenantId) {
        return this.baseMapper.selectById(tenantId);
    }
}
