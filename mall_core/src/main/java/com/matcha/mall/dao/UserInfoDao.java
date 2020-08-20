package com.matcha.mall.dao;

import com.matcha.mall.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息
 * 
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
	
}
