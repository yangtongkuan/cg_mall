package com.matcha.mall.common.config;

import com.matcha.mall.common.filter.SysReqTenantFilter;
import com.matcha.mall.common.filter.UserAuthFilter;
import com.matcha.mall.common.service.SysTenantRemoteService;
import com.matcha.mall.common.service.UserRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置类
 */
@Configuration
public class FilterConfig {


    @Autowired
    private SysTenantRemoteService sysTenantRemoteService;

    @Autowired
    private UserRemoteService userRemoteService;

    /**
     * 系统租户配置信息
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "mall", name = "tenant.filter.open", havingValue = "true", matchIfMissing = true)
    public FilterRegistrationBean registerTenantFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SysReqTenantFilter(sysTenantRemoteService));
        registration.addUrlPatterns("/*");
        registration.setName("sysReqTenantFilter");
        registration.setOrder(1);  // 值越小，Filter越靠前。
        return registration;
    }


    /**
     * 系统租户配置信息
     *
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "mall", name = "user.auth.filter.open", havingValue = "true", matchIfMissing = true)
    public FilterRegistrationBean registerAuthFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new UserAuthFilter(userRemoteService));
        registration.addUrlPatterns("/v1/*/pri/*");
        registration.setName("registerAuthFilter");
        registration.setOrder(5);  // 值越小，Filter越靠前。
        return registration;
    }


}
