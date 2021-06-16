package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.UserRole;
import com.hankun.satokenlearn.mapper.UserRoleMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class UserRoleServiceImpl extends BaseService<UserRoleMapper, UserRole> implements UserRoleService {

    /**
     * 获取表格数据
     *
     * @param userRole
     * @return
     */
    public IPage<UserRole> getPageListByEntity(UserRole userRole) {
        LambdaQueryWrapper<UserRole> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(userRole.getRoleId()), UserRole::getRoleId, userRole.getRoleId());
        return super.page(userRole, queryWrapper);
    }

}
