package com.matcha.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matcha.mall.dao.SysTenantDao;
import com.matcha.mall.entity.SysTenantEntity;
import com.matcha.mall.service.SysTenantService;
import org.springframework.stereotype.Service;

@Service("sysTenantService")
public class SysTenantServiceImpl extends ServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {

}
