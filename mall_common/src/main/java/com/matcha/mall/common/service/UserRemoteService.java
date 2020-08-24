package com.matcha.mall.common.service;

import com.matcha.mall.common.dto.UserInfoDto;

/**
 * 用户远程服务
 */
public interface UserRemoteService {

    default UserInfoDto getUserInfoDto(Long tenantId, String token) {
        return null;
    }
}
