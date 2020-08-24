package com.matcha.mall.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfoVO implements Serializable {

    /**
     *
     */
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
    private Integer isLock;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * token信息
     */
    private String token;

}
