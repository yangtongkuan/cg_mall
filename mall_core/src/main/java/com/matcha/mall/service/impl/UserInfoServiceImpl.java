package com.matcha.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matcha.mall.dao.UserInfoDao;
import com.matcha.mall.entity.UserInfoEntity;
import com.matcha.mall.service.UserInfoService;


@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {

    @Override
    public UserInfoEntity findByTenantByIdAndPhone(Long tenantId, String phone) {
        QueryWrapper<UserInfoEntity> wrapper = new QueryWrapper<>();
        return this.baseMapper.selectOne(wrapper.eq("tenant_id", tenantId).eq("phone", phone));
    }
}