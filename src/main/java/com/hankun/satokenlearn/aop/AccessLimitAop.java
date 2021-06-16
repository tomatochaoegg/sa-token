package com.hankun.satokenlearn.aop;

import com.hankun.satokenlearn.annontions.AccessLimit;
import com.hankun.satokenlearn.util.RequestIpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Author hankun
 * @Description TODO
 * @Date 2021/6/9
 * @Version 1.0
 */
@Aspect
@Component
public class AccessLimitAop {

    /**
     * 指定泛型时 不能使用autowired（按照类型匹配），需要按照名称匹配
     */
    @Resource
    private RedisTemplate<String,Integer> redisTemplate;

    @Pointcut(value = "@annotation(com.hankun.satokenlearn.annontions.AccessLimit)")
    public void cutLimit(){}

    @Around("cutLimit()")
    public Object recordSysLog(ProceedingJoinPoint point)throws Throwable{
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        AccessLimit accessLimit = method.getAnnotation(AccessLimit.class);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        if (null == accessLimit) {
            return point.proceed();
        }
        int seconds = accessLimit.seconds();
        int maxCount = accessLimit.maxCount();
        boolean needLogin = accessLimit.needLogin();

        if (needLogin) {
            //判断是否登录

        }
        String key = ms.getName() + ":" + RequestIpUtils.getIpAddr();

        Integer count = redisTemplate.opsForValue().get(key);
        Long expire = redisTemplate.getExpire(key);
        if (null == count || -1 == count) {
            redisTemplate.opsForValue().set(key, 1,seconds, TimeUnit.SECONDS);
            return point.proceed();
        }

        if (count < maxCount) {
            redisTemplate.opsForValue().increment(key);
            return point.proceed();
        }

        if (count >= maxCount) {
// response 返回 json 请求过于频繁请稍后再试
            String str = "{\n" +
                    "\t\"success\": 1,\n" +
                    "\t\"message\": \"频繁访问\"\n" +
                    "}";
            return str;
        }
        return point.proceed();
    }

}
