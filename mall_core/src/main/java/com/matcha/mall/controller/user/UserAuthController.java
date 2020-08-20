package com.matcha.mall.controller.user;

import com.matcha.mall.VO.UserAuthVO;
import com.matcha.mall.VO.UserInfoVO;
import com.matcha.mall.common.controller.AbstractController;
import com.matcha.mall.entity.UserInfoEntity;
import com.matcha.mall.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户认证信息
 */
@RestController
@RequestMapping("/v1/user/")
public class UserAuthController extends AbstractController {


    @Autowired
    private UserAuthService userAuthService;

    /**
     * 用户通过密码登录
     *
     * @return
     */
    @RequestMapping("/pub/auth-pwd")
    public UserInfoEntity login(@RequestBody @Validated UserAuthVO userAuth) {
        UserInfoVO userInfoVO = userAuthService.userAuthByPasswd(getLocalTenant().getTenantId(), userAuth);
        return null;
    }

    /**
     * 用户登出
     *
     * @param tenantId
     * @param userInfo
     * @return
     */
    @RequestMapping("/pub/logout")
    public String logout(Long tenantId, UserInfoEntity userInfo) {


        return "ok";
    }


}
