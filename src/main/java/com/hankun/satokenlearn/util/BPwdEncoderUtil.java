package com.hankun.satokenlearn.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: hankun
 * @Date: 2021/6/7
 * @Description: 密码加密
 */
public class BPwdEncoderUtil {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 匹配密码
     *
     * @param rawPassword     未加密密码
     * @param encodedPassword 加密密码
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
