package com.hankun.satokenlearn.aop;

import com.alibaba.fastjson.JSON;
import com.hankun.satokenlearn.util.RequestIpUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hankun
 * @Description 接口日志切面
 * @Date 2021/5/26
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class MethodTimeAspect {

    @Pointcut("execution(public * com.hankun.satokenlearn.controller.*.*(..))")
    public void requestServer() {
    }

    @Around("requestServer()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object result = proceedingJoinPoint.proceed();
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setIp(RequestIpUtils.getIpAddr());
        requestInfo.setUrl(request.getRequestURL().toString());
//        requestInfo.setHttpMethod(request.getMethod());
//        requestInfo.setClassMethod(String.format("%s.%s", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
//                proceedingJoinPoint.getSignature().getName()));
        requestInfo.setRequestParams(getRequestParamsByProceedingJoinPoint(proceedingJoinPoint));
        requestInfo.setResult(StringUtils.substring(JSON.toJSONString(result),0,300));
        requestInfo.setTimeCost(System.currentTimeMillis() - start);
        log.info("Request Info      : {}", requestInfo);

        return result;
    }


    @AfterThrowing(pointcut = "requestServer()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, RuntimeException e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequestErrorInfo requestErrorInfo = new RequestErrorInfo();
        requestErrorInfo.setIp(RequestIpUtils.getIpAddr());
        requestErrorInfo.setUrl(request.getRequestURL().toString());
        requestErrorInfo.setHttpMethod(request.getMethod());
        requestErrorInfo.setRequestParams(getRequestParamsByJoinPoint(joinPoint));
//        e.printStackTrace();
        log.info("Error Request Info      : {}", requestErrorInfo);
    }

    /**
     * 获取入参
     * @param proceedingJoinPoint
     *
     * @return
     * */
    private Map<String, Object> getRequestParamsByProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = proceedingJoinPoint.getArgs();
        return buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> getRequestParamsByJoinPoint(JoinPoint joinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = joinPoint.getArgs();
        return buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> buildRequestParam(String[] paramNames, Object[] paramValues) {
        Map<String, Object> requestParams = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];
            //如果是文件对象
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                value = file.getOriginalFilename();  //获取文件名
            }
            if (value instanceof ServletRequest) {
                break;
            }
            if (value instanceof ServletResponse) {
                break;
            }
            requestParams.put(paramNames[i], value);
        }
        return requestParams;
    }

    @Data
    class RequestErrorInfo {
        private String ip;//可能拿不到真实ip 需要单独写工具类
        private String url;
        private String httpMethod;
        //        private String classMethod;
        private Object requestParams;
        private RuntimeException exception;
    }

    @Data
    class RequestInfo {
        private String ip;
        private String url;
        private String httpMethod;
        //        private String classMethod;
        private Object requestParams;
        private Long timeCost;
        private Object result;
    }
}
