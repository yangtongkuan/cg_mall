package com.matcha.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
@Data
@TableName("user_imp_info")
public class UserImpInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer userImpId;
	/**
	 * 租户id
	 */
	private Long tenantId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 密码
	 */
	private String passwd;
	/**
	 * 盐值
	 */
	private String salt;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 是否已删除(1已删除，0未删除)
	 */
	private Integer delflag;
	/**
	 * 创建者id
	 */
	private Long createUserId;
	/**
	 * 创建日期  141231212423423时间戳毫秒级标识
	 */
	private Date createTime;
	/**
	 * 删除者id
	 */
	private Long delUserId;

}
