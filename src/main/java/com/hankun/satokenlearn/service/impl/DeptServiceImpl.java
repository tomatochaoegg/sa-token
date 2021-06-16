package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Dept;
import com.hankun.satokenlearn.mapper.DeptMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class DeptServiceImpl extends BaseService<DeptMapper, Dept> implements DeptService {

    /**
     * 获取表格数据
     *
     * @param dept
     * @return
     */
    public IPage<Dept> getPageListByEntity(Dept dept) {
        LambdaQueryWrapper<Dept> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(dept.getParentId()), Dept::getParentId, dept.getParentId());
        queryWrapper.like(StrUtil.isNotBlank(dept.getAncestors()), Dept::getAncestors, dept.getAncestors());
        queryWrapper.like(StrUtil.isNotBlank(dept.getName()), Dept::getName, dept.getName());
        queryWrapper.like(StrUtil.isNotBlank(dept.getPhone()), Dept::getPhone, dept.getPhone());
        queryWrapper.like(StrUtil.isNotBlank(dept.getEmail()), Dept::getEmail, dept.getEmail());
        queryWrapper.like(StrUtil.isNotBlank(dept.getDeptStatus()), Dept::getDeptStatus, dept.getDeptStatus());
        return super.page(dept, queryWrapper);
    }

}
