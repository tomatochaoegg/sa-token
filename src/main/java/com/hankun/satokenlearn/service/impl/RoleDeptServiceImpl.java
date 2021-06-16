package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.RoleDept;
import com.hankun.satokenlearn.mapper.RoleDeptMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.RoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class RoleDeptServiceImpl extends BaseService<RoleDeptMapper, RoleDept> implements RoleDeptService {

    /**
     * 获取表格数据
     *
     * @param roleDept
     * @return
     */
    public IPage<RoleDept> getPageListByEntity(RoleDept roleDept) {
        LambdaQueryWrapper<RoleDept> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(roleDept.getDeptId()), RoleDept::getDeptId, roleDept.getDeptId());
        return super.page(roleDept, queryWrapper);
    }

}
