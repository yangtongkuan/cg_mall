package com.matcha.mall.common.config;

import com.matcha.mall.common.service.SysTenantService;
import com.matcha.mall.common.service.impl.SysTenantServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {

    @Bean
    @ConditionalOnMissingBean(SysTenantService.class)
    public SysTenantService sysTenantService() {
        return new SysTenantServiceImpl();
    }
}
