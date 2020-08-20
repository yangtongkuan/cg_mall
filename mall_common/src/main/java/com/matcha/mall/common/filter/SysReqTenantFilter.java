package com.matcha.mall.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matcha.mall.common.entity.SysTenantEntity;
import com.matcha.mall.common.utils.SysTenantUtils;
import com.matcha.mall.common.api.CommonResult;
import com.matcha.mall.common.api.ResultCode;
import com.matcha.mall.common.service.SysTenantService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 请求租户过滤
 */

public class SysReqTenantFilter implements Filter {

    private final static String SYS_TENANT = "tenantId";

    private SysTenantService sysTenantService;

    public SysReqTenantFilter(SysTenantService sysTenantService) {
        this.sysTenantService = sysTenantService;
    }

    private Long getRequestTenant(HttpServletRequest httpRequest) {
        //从header中获取tTenant
        String tenantId = httpRequest.getHeader(SYS_TENANT);
        //如果header中不存在Tenant，则从参数中获取Tenant
        if (StringUtils.isBlank(tenantId)) {
            tenantId = httpRequest.getParameter(SYS_TENANT);
        }
        try {
            return StringUtils.isBlank(tenantId) ? null : Long.parseLong(tenantId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeJson(HttpServletResponse res, String json) {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        try (PrintWriter writer = res.getWriter()) {
            writer.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        Long tenantId = getRequestTenant(request);
        if (tenantId == null) {
            CommonResult<String> commonResult = CommonResult.failed(ResultCode.INVALID_TENANT);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(commonResult);
            writeJson(res, json);
            return;
        }
        SysTenantEntity sysTenantInfo = sysTenantService.findSysTenantByTenantId(tenantId);
        if (sysTenantInfo == null) {
            CommonResult<String> commonResult = CommonResult.failed(ResultCode.INVALID_TENANT);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(commonResult);
            writeJson(res, json);
            return;
        }
        // 设置当前线程的租户信息
        SysTenantUtils.setLocalTenant(sysTenantInfo);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 删除当前线程的租户信息
            SysTenantUtils.remove();
        }
    }

    @Override
    public void destroy() {

    }


}
