package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.entity.UserInfo;
import com.hankun.satokenlearn.mapper.UserInfoMapper;
import com.hankun.satokenlearn.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class UserInfoServiceImpl extends BaseService<UserInfoMapper, UserInfo> implements UserInfoService {

    /**
     * 获取表格数据
     *
     * @param userInfo
     * @return
     */
    public IPage<UserInfo> getPageListByEntity(UserInfo userInfo) {
        LambdaQueryWrapper<UserInfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getDeptId()), UserInfo::getDeptId, userInfo.getDeptId());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getUsername()), UserInfo::getUsername, userInfo.getUsername());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getPassword()), UserInfo::getPassword, userInfo.getPassword());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getNickName()), UserInfo::getNickName, userInfo.getNickName());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getUserType()), UserInfo::getUserType, userInfo.getUserType());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getEmail()), UserInfo::getEmail, userInfo.getEmail());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getPhoneNumber()), UserInfo::getPhoneNumber, userInfo.getPhoneNumber());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getSex()), UserInfo::getSex, userInfo.getSex());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getAvatarPath()), UserInfo::getAvatarPath, userInfo.getAvatarPath());
        queryWrapper.like(StrUtil.isNotBlank(userInfo.getUserStatus()), UserInfo::getUserStatus, userInfo.getUserStatus());
        return super.page(userInfo, queryWrapper);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    public UserInfo getUserInfoByUsername(String username) {
        return super.getOne(Wrappers.<UserInfo>lambdaQuery().eq(UserInfo::getUsername, username).last("LIMIT 1"));
    }

}
