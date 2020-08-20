package com.matcha.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matcha.mall.entity.UserInfoEntity;


/**
 * 用户信息
 *
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
public interface UserInfoService extends IService<UserInfoEntity> {

    UserInfoEntity findByTenantByIdAndPhone(Long tenantId, String phone);

}

