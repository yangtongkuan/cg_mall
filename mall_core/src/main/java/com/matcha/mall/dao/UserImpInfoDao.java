package com.matcha.mall.dao;

import com.matcha.mall.entity.UserImpInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
@Mapper
public interface UserImpInfoDao extends BaseMapper<UserImpInfoEntity> {

    UserImpInfoEntity findByTenantIdAndUserId(@Param("tenantId") Long tenantId, @Param("userId") Long userId);

}
