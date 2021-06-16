package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Role;
import com.hankun.satokenlearn.mapper.RoleMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class RoleServiceImpl extends BaseService<RoleMapper, Role> implements RoleService {

    /**
     * 获取表格数据
     *
     * @param role
     * @return
     */
    public IPage<Role> getPageListByEntity(Role role) {
        LambdaQueryWrapper<Role> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(role.getRoleName()), Role::getRoleName, role.getRoleName());
        queryWrapper.like(StrUtil.isNotBlank(role.getRoleKey()), Role::getRoleKey, role.getRoleKey());
        queryWrapper.like(StrUtil.isNotBlank(role.getRoleStatus()), Role::getRoleStatus, role.getRoleStatus());
        queryWrapper.like(StrUtil.isNotBlank(role.getDataScope()), Role::getDataScope, role.getDataScope());
        return super.page(role, queryWrapper);
    }

}
