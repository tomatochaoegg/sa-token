package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyRole;
import com.hankun.satokenlearn.mapper.MyRoleMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyRoleService;
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
public class MyRoleServiceImpl extends BaseService<MyRoleMapper, MyRole> implements MyRoleService {

    /**
     * 获取表格数据
     *
     * @param myRole
     * @return
     */
    public IPage<MyRole> getPageListByEntity(MyRole myRole) {
        LambdaQueryWrapper<MyRole> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myRole.getRoleName()), MyRole::getRoleName, myRole.getRoleName());
        queryWrapper.like(StrUtil.isNotBlank(myRole.getDescription()), MyRole::getDescription, myRole.getDescription());
        queryWrapper.like(StrUtil.isNotBlank(myRole.getDataScope()), MyRole::getDataScope, myRole.getDataScope());
        return super.page(myRole, queryWrapper);
    }

}
