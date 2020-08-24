package com.matcha.mall.common.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统租户
 * 
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
@Data
@TableName("sys_tenant")
public class SysTenantEntityDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long tenantId;
	/**
	 * 租户名称
	 */
	private String tenantName;
	/**
	 * 负责人
	 */
	private String managerName;
	/**
	 * 联系电话
	 */
	private String managerPhone;
	/**
	 * 省
	 */
	private String prov;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 区县
	 */
	private String county;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 是否长期有效
	 */
	private Integer forEver;
	/**
	 * 到期时间
	 */
	private Date expireTime;
	/**
	 * 最后续期时间
	 */
	private Date lastRenewalTime;
	/**
	 * 是否删除
	 */
	private Integer delFlag;
	/**
	 * 删除者id
	 */
	private Long delUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建者id
	 */
	private Long createUserId;

}
