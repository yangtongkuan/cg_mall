package com.matcha.mall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 20:04
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
@Data
@Accessors(chain = true)
@TableName("user_token")
public class UserTokenEntity {

    @TableField
    private Long tokenId;           // tokenId
    private String token;           // token
    private Long tenantId;          // 租户
    private Long userId;            // 用户
    private Date expireDate;        // 到期时间
    private String device;          // 设备
}
