package com.matcha.mall.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.matcha.mall.dao.UserImpInfoDao;
import com.matcha.mall.entity.UserImpInfoEntity;
import com.matcha.mall.service.UserImpInfoService;


@Service("userImpInfoService")
public class UserImpInfoServiceImpl extends ServiceImpl<UserImpInfoDao, UserImpInfoEntity> implements UserImpInfoService {


}