package com.hankun.satokenlearn.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.io.IoUtil;
import com.hankun.satokenlearn.constant.Constant;
import com.hankun.satokenlearn.util.RequestIpUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author hankun
 * @Description TODO
 * @Date 2021/6/4
 * @Version 1.0
 */
@RestController
@Slf4j
public class CommonController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/active")
    public String activeTest(){
        return "ok";
    }

    @ApiOperation(value = "生成验证码", notes = "生成验证码" ,produces = "image/png")
    @GetMapping(value = "/render")
    public void render(HttpServletResponse response) throws IOException {
        String ipAdrress = RequestIpUtils.getIpAddr();
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(200, 50, 4, 4);
        shearCaptcha.write(response.getOutputStream());
        log.info("验证码 [{}]", shearCaptcha.getCode());
        // 验证码过期时间一分钟
        redisTemplate.opsForValue().set(Constant.REDIS_CAPTCHA_KEY+ipAdrress, shearCaptcha.getCode(), 1, TimeUnit.MINUTES);
        // 校验验证码
        boolean verify = shearCaptcha.verify(shearCaptcha.getCode());
        log.info("验证码结果 [{}]", shearCaptcha.verify("1234"));
        log.info("验证码结果 [{}]", verify);
        // 关闭流
        String code = redisTemplate.opsForValue().get(Constant.REDIS_CAPTCHA_KEY + ipAdrress);
        log.info("验证码结果 redis [{}]", code);
        IoUtil.close(response.getOutputStream());
    }

}
