package com.matcha.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matcha.mall.entity.UserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * token管理
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 20:01
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Mapper
public interface UserTokenDao extends BaseMapper<UserTokenEntity> {
}
