package com.matcha.mall.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 22:06
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Data
public class UserInfoDto {
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
    private Integer lock;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * token信息
     */
    private String token;

}
