package com.matcha.mall.common.config;

import com.matcha.mall.common.dto.SysTenantEntityDto;
import com.matcha.mall.common.dto.UserInfoDto;
import com.matcha.mall.common.service.SysTenantRemoteService;
import com.matcha.mall.common.service.UserRemoteService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {

    @Bean
    @ConditionalOnMissingBean(SysTenantRemoteService.class)
    public SysTenantRemoteService sysTenantService() {
        return new SysTenantRemoteService() {
            @Override
            public SysTenantEntityDto findSysTenantByTenantId(Long tenantId) {
                return null;
            }
        };
    }

    /**
     * 用户远程服务
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(UserRemoteService.class)
    public UserRemoteService userRemoteService() {
        return new UserRemoteService() {
            @Override
            public UserInfoDto getUserInfoDto(Long tenantId, String token) {
                return null;
            }
        };
    }
}
