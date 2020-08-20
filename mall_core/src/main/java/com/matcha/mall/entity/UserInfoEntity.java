package com.matcha.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息
 *
 * @author yangtk
 * @email yangtongkuan@qq.com
 * @date 2020-08-19 20:06:59
 */
@Data
@TableName("user_info")
public class UserInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long userId;
    /**
     * 租户id
     */
    private Long tenantId;
    /**
     * 账号_系統生成
     */
    private String userName;
    /**
     * 昵称
     */
    private String name;
    /**
     * 绑定电话
     */
    private String phone;
    /**
     * 联系电话
     */
    private String telPhone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String signPhoto;
    /**
     * 个性签名
     */
    private String signature;
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
     * 是否锁定
     */
    private Integer lock;
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
