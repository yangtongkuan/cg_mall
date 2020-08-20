package com.matcha.mall.service;

import com.matcha.mall.VO.UserAuthVO;
import com.matcha.mall.VO.UserInfoVO;

public interface UserAuthService {

    UserInfoVO userAuthByPasswd(Long tenantId, UserAuthVO userAuth);
}
