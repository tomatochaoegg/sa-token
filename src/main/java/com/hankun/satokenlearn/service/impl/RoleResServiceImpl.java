package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.RoleRes;
import com.hankun.satokenlearn.mapper.RoleResMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.RoleResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和资源关联表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class RoleResServiceImpl extends BaseService<RoleResMapper, RoleRes> implements RoleResService {

    /**
     * 获取表格数据
     *
     * @param roleRes
     * @return
     */
    public IPage<RoleRes> getPageListByEntity(RoleRes roleRes) {
        LambdaQueryWrapper<RoleRes> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(roleRes.getResId()), RoleRes::getResId, roleRes.getResId());
        return super.page(roleRes, queryWrapper);
    }

}
