package com.matcha.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.matcha.mall.entity.UserImpInfoEntity;
import com.matcha.mall.entity.UserTokenEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 20:13
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
public interface UserTokenService extends IService<UserTokenEntity> {
    String generateUserToken(Long tenantId, Long userId);

}
