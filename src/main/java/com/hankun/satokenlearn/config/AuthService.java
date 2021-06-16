package com.hankun.satokenlearn.config;

import cn.hutool.core.collection.CollUtil;
import com.hankun.satokenlearn.mapper.MyUserMapper;
import com.hankun.satokenlearn.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author hankun
 * @Description 查询用户角色、权限信息
 * @Date 2021/6/4
 * @Version 1.0
 */
@Service
public class AuthService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private MyUserMapper myUserMapper;

    /**
     * 设置权限
     *
     * @param userId
     * @return
     */
    public Set<String> getAuthRoleAndResourceByUserId(String userId) {
        // 查询权限
        Set<String> resourcesCodeList = userInfoMapper.getResourcesCodeByUserId(userId);
        Set<String> roleKeyList = userInfoMapper.getAuthRoleKeyByUserId(userId);
        CollUtil.addAll(resourcesCodeList, roleKeyList);
        return resourcesCodeList;
    }

    /**
     * 根据用户id 刷新session里面的用户信息，只能修改登录人
     *
     * @param userId
     */
//    public void refreshUserInfoByUserId(String userId) {
//        SaSession session = StpUtil.getSessionByLoginId(userId, false);
//        if (session != null) {
//            Set<String> authRoleAndResourceByUserId = getAuthRoleAndResourceByUserId(userId);
//            LoginOutputDTO loginOutputDTO = session.getModel(Constant.SESSION_USER_KEY, LoginOutputDTO.class);
//            loginOutputDTO.setResources(authRoleAndResourceByUserId);
//            session.setAttribute(Constant.SESSION_USER_KEY, loginOutputDTO);
//        }
//    }

    /**
     * 根据用户id查询权限集合
     *
     * @param userId
     * @return
     */
//    @Cacheable(value = "user:resource", key = "#userId")
    public List<String> getResourcesCodeByUserId(String userId) {
        Set<String> resourcesCodeByUserId = userInfoMapper.getResourcesCodeByUserId(userId);
        return CollUtil.newArrayList(resourcesCodeByUserId);
    }

    /**
     * 根据用户id查询角色集合
     *
     * @param userId
     * @return
     */
//    @Cacheable(value = "user:role", key = "#userId")
    public List<String> getAuthRoleKeyByUserId(String userId) {
        Set<String> authRoleKeyByUserId = userInfoMapper.getAuthRoleKeyByUserId(userId);
        return CollUtil.newArrayList(authRoleKeyByUserId);
    }

    /**
     * 第二套用户权限
     *
     * @param userId
     * @return
     */
    public List<String> getPermissionByUserId(Integer userId) {
        Set<String> resourcesCodeByUserId = myUserMapper.getPermissionByUserId(userId);
        return CollUtil.newArrayList(resourcesCodeByUserId);
    }

    /**
     * 第二套用户角色
     *
     * @param userId
     * @return
     */
    public List<String> getRoleByUserId(Integer userId) {
        Set<String> authRoleKeyByUserId = myUserMapper.getRoleByUserId(userId);
        return CollUtil.newArrayList(authRoleKeyByUserId);
    }

}
