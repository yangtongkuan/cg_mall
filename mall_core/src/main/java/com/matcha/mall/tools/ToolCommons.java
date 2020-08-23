package com.matcha.mall.tools;

import cn.hutool.crypto.SecureUtil;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 工具类
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/8/23 18:19
 * @Email: yangtongkuan@qq.com
 * @To change this template use File | Settings | File Templates.
 */
public class ToolCommons {

    // 是否使用时间生成token
    private static final boolean generateUseDate = false;

    // token生成工具
    private static final StringBuffer tokenGenerateStr = new StringBuffer("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final StringBuffer tokenGenerateStr2 = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

    // token长度
    private static final int tokenLength = 24;
    // 加盐字符串长度
    private static final int slatLength = 20;

    public static final int TOKEN_VALID_DAY = 30;

    // 生成token
    public static String generateToken() {
        return generateToken(null, null);
    }

    // 组成方式 时间MMddHHmmssSSS + tenantId+random + userId+random+random
    public static String generateToken(Long tenantId, Long userId) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = tokenGenerateStr.length();
        if (generateUseDate) {
            SimpleDateFormat format = new SimpleDateFormat("MMddHHmmssSSS");
            sb.append(format.format(new Date()));
        }
        if (tenantId != null) {
            sb.append(tenantId).append(tokenGenerateStr.charAt(random.nextInt(range)));
        }
        if (userId != null) {
            sb.append(userId).append(tokenGenerateStr.charAt(random.nextInt(range)));
        }
        int tLength = sb.length();
        for (int i = tLength; i <= tokenLength; i++) {
            sb.append(tokenGenerateStr2.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    // 先生成20位字符串、然后进行md5加密 生成slat加盐
    private static String generateSlat(Long tenantId, Long userId) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = tokenGenerateStr.length();
        if (tenantId != null) {
            sb.append(tenantId).append(tokenGenerateStr.charAt(random.nextInt(range)));
        }
        if (userId != null) {
            sb.append(userId).append(tokenGenerateStr.charAt(random.nextInt(range)));
        }
        int tLength = sb.length();
        for (int i = tLength; i <= slatLength; i++) {
            sb.append(tokenGenerateStr2.charAt(random.nextInt(range)));
        }
        return SecureUtil.md5(sb.toString());
    }

    // 生成pwd md5(md5(pwd)+slat)
    public static String generatePwdMd5(String pwd, String slat) {
        if (StringUtils.isNotEmpty(slat)) {
            return SecureUtil.md5(SecureUtil.md5(pwd) + slat);
        } else {
            return SecureUtil.md5(SecureUtil.md5(pwd));
        }
    }

    // 匹配密码是否正觉
    public static boolean matchPwd(String matchPwd, String pwd, String slat) {
        return generatePwdMd5(pwd, slat).equals(matchPwd);
    }


    public static void main(String[] args) {
        System.out.println(generateToken(null, null));
    }


}
