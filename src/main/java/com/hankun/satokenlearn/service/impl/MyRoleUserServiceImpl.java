package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyRoleUser;
import com.hankun.satokenlearn.mapper.MyRoleUserMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyRoleUserService;
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
public class MyRoleUserServiceImpl extends BaseService<MyRoleUserMapper, MyRoleUser> implements MyRoleUserService {

    /**
     * 获取表格数据
     *
     * @param myRoleUser
     * @return
     */
    public IPage<MyRoleUser> getPageListByEntity(MyRoleUser myRoleUser) {
        LambdaQueryWrapper<MyRoleUser> queryWrapper = Wrappers.lambdaQuery();
        return super.page(myRoleUser, queryWrapper);
    }

}
