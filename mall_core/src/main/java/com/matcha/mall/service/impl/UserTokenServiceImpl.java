package com.matcha.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matcha.mall.dao.UserTokenDao;
import com.matcha.mall.entity.UserTokenEntity;
import com.matcha.mall.service.UserTokenService;
import com.matcha.mall.tools.ToolCommons;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 20:14
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenDao, UserTokenEntity> implements UserTokenService {


    /**
     * 生成一个token
     *
     * @param tenantId
     * @param userId
     * @return
     */
    @Override
    public String generateUserToken(Long tenantId, Long userId) {
        this.deleteExpireToken(tenantId, userId);
        UserTokenEntity tokenEntity = new UserTokenEntity();
        tokenEntity.setTenantId(tenantId).setUserId(userId);
        String token = ToolCommons.generateToken(tenantId, userId);
        tokenEntity.setToken(token);
        Date expireDate = new Date(System.currentTimeMillis() + ToolCommons.TOKEN_VALID_DAY * 24 * 60 * 60 * 1000L);
        tokenEntity.setExpireDate(expireDate);
        this.baseMapper.insert(tokenEntity);
        return token;
    }

    // 删除过期的token
    private void deleteExpireToken(Long tenantId, Long userId) {
        QueryWrapper<UserTokenEntity> wrapper = new QueryWrapper<>();
        if (tenantId != null) {
            wrapper.eq("tenant_id", tenantId);
        }
        if (userId != null) {
            wrapper.eq("user_id", userId);
        }
        wrapper.le("expire_date", new Date());
        this.baseMapper.delete(wrapper);
    }


}
