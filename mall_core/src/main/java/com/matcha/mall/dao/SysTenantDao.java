package com.matcha.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.matcha.mall.common.entity.SysTenantEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统租户
 * 
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
@Mapper
public interface SysTenantDao extends BaseMapper<SysTenantEntity> {
	
}
