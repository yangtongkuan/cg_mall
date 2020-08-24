package com.matcha.mall.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matcha.mall.common.api.CommonResult;
import com.matcha.mall.common.api.ResultCode;
import com.matcha.mall.common.dto.UserInfoDto;
import com.matcha.mall.common.dto.SysTenantEntityDto;
import com.matcha.mall.common.service.UserRemoteService;
import com.matcha.mall.common.utils.SysTenantUtils;
import com.matcha.mall.common.utils.UserAuthUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录过滤器 - 必须登录的连接过滤
 */
public class UserAuthFilter implements Filter {


    private UserRemoteService userRemoteService;

    private static final String USER_TOKEN = "token";

    public UserAuthFilter(UserRemoteService userRemoteService) {
        this.userRemoteService = userRemoteService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String _token = getRequestToken(request);
        SysTenantEntityDto tenantEntity = SysTenantUtils.get();
        UserInfoDto infoDto = userRemoteService.getUserInfoDto(tenantEntity.getTenantId(), _token);
        if (infoDto == null) {
            CommonResult<String> commonResult = CommonResult.failed(ResultCode.INVALID_TENANT);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(commonResult);
            writeJson(res, json);
            return;
        }
        // 设置当前线程的用户信息
        UserAuthUtils.setLocalTenant(infoDto);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 删除当前线程的用户信息
            UserAuthUtils.remove();
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 获取token信息
     * @param httpRequest
     * @return
     */
    private String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String _token = httpRequest.getHeader(USER_TOKEN);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(_token)) {
            _token = httpRequest.getParameter(USER_TOKEN);
        }
        return _token;
    }


    /**
     * 写到json中
     * @param res
     * @param json
     */
    private void writeJson(HttpServletResponse res, String json) {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json");
        try (PrintWriter writer = res.getWriter()) {
            writer.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
