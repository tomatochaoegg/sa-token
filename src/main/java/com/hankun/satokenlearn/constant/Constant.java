package com.hankun.satokenlearn.constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author hankun
 * @Description TODO
 * @Date 2021/6/4
 * @Version 1.0
 */
public interface Constant {
    /**
     * 线程池
     */
    ExecutorService EXECUTOR = Executors.newFixedThreadPool(10);

    String SESSION_USER_KEY = "UserInfo";
    /**
     * 存储用户权限
     */
    String REDIS_CAPTCHA_KEY = "user:captcha:";
    String REDIS_ROUTER_LOCK = "resource:router:lock";

    /**
     * 魔法值
     */
    String ZERO = "0";
    String ONE = "1";
    String TWO = "2";
    String THREE = "3";
    String FOUR = "4";
    String FIVE = "5";
    String SIX = "6";
    String SEVEN = "7";
    String EIGHT = "8";
    String NINE = "9";
}
