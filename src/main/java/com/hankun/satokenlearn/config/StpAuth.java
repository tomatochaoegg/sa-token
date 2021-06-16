package com.hankun.satokenlearn.config;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author hankun
 * @Description 将角色、权限交给框架
 * @Date 2021/6/4
 * @Version 1.0
 */
@Component
public class StpAuth implements StpInterface {

    @Autowired
    private AuthService authService;


    /**
     * 返回账号拥有的权限码
     *
     * @param loginId
     * @param loginKey
     * @return
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginKey) {
        if (StringUtils.equalsIgnoreCase(StpUtil.getLoginKey(),loginKey)){
            return authService.getResourcesCodeByUserId((String) loginId);
        }
        if (StringUtils.equalsIgnoreCase(StpUserUtil.getLoginKey(),loginKey)){
            return authService.getPermissionByUserId(Integer.valueOf(loginId.toString()));//另一套账号体系
        }
        return null;
    }

    /**
     * 返回账号拥有的角色标识
     *
     * @param loginId
     * @param loginKey
     * @return
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginKey) {
        if (StringUtils.equalsIgnoreCase(StpUtil.getLoginKey(),loginKey)){
            return authService.getAuthRoleKeyByUserId((String) loginId);
        }
        if (StringUtils.equalsIgnoreCase(StpUserUtil.getLoginKey(),loginKey)){
            return authService.getRoleByUserId((Integer) loginId);//另一套账号体系
        }
        return null;
    }
}
