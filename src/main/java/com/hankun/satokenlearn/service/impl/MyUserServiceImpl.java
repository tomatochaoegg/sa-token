package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyUser;
import com.hankun.satokenlearn.entity.UserInfo;
import com.hankun.satokenlearn.mapper.MyUserMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@Service
public class MyUserServiceImpl extends BaseService<MyUserMapper, MyUser> implements MyUserService {

    /**
     * 获取表格数据
     *
     * @param myUser
     * @return
     */
    public IPage<MyUser> getPageListByEntity(MyUser myUser) {
        LambdaQueryWrapper<MyUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myUser.getUserName()), MyUser::getUserName, myUser.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(myUser.getPassword()), MyUser::getPassword, myUser.getPassword());
        queryWrapper.like(StrUtil.isNotBlank(myUser.getNickName()), MyUser::getNickName, myUser.getNickName());
        queryWrapper.like(StrUtil.isNotBlank(myUser.getPhone()), MyUser::getPhone, myUser.getPhone());
        queryWrapper.like(StrUtil.isNotBlank(myUser.getEmail()), MyUser::getEmail, myUser.getEmail());
        return super.page(myUser, queryWrapper);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    public MyUser getUserInfoByUsername(String username) {
        return super.getOne(Wrappers.<MyUser>lambdaQuery().eq(MyUser::getUserName, username).last("LIMIT 1"));
    }

}
