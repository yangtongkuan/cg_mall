package com.matcha.mall.VO;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 用户认证 接受前端传递的model
 */
@Data
public class UserAuthVO {

    /**
     * 用户名 这个用户名可能不太准确 可能是手机号 email等
     */
    @NotEmpty(message = "用户账号不能为空")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String passwd;
}
