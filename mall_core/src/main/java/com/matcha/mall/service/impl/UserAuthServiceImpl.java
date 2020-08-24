package com.matcha.mall.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.matcha.mall.VO.UserAuthVO;
import com.matcha.mall.VO.UserInfoVO;
import com.matcha.mall.common.api.ResultCode;
import com.matcha.mall.common.exception.MallCustomException;
import com.matcha.mall.common.utils.CgAssertUtils;
import com.matcha.mall.dao.UserImpInfoDao;
import com.matcha.mall.entity.UserImpInfoEntity;
import com.matcha.mall.entity.UserInfoEntity;
import com.matcha.mall.service.UserAuthService;
import com.matcha.mall.service.UserInfoService;
import com.matcha.mall.service.UserTokenService;
import com.matcha.mall.tools.ToolCommons;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private UserImpInfoDao userImpInfoDao;

    /**
     * 密码登录认证
     *
     * @param tenantId
     * @param userAuth
     * @return
     */
    @Override
    @Transactional
    public UserInfoVO userAuthByPasswd(Long tenantId, UserAuthVO userAuth) {
        UserInfoEntity userInfoEntity = userInfoService.findByTenantByIdAndPhone(tenantId, userAuth.getUsername());
        CgAssertUtils.notNull(userInfoEntity, "未查询到用户信息");
        UserImpInfoEntity userImpInfoEntity = userImpInfoDao.findByTenantIdAndUserId(tenantId, userInfoEntity.getUserId());
        CgAssertUtils.notNull(userImpInfoEntity, "未获取到用户密码信息");
        // 进行比对
        if (!ToolCommons.matchPwd(userImpInfoEntity.getPasswd(), userAuth.getPasswd(), userImpInfoEntity.getSalt())) {
            throw new MallCustomException(ResultCode.FAILED).setMessage("用户或密码不正确");
        }
        String token = userTokenService.generateUserToken(tenantId, userImpInfoEntity.getUserId());
        CgAssertUtils.notNull(token, "获取token失败");
        // todo 生成token
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(userInfoEntity, userInfoVO);
        userInfoVO.setToken(token);
        return userInfoVO;
    }

    public static void main(String[] args) {
        String slat = "test";
        slat = SecureUtil.md5(slat);
        System.out.println(SecureUtil.md5(SecureUtil.md5("123456") + slat));
    }
}
