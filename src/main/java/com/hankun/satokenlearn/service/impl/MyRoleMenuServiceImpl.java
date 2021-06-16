package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyRoleMenu;
import com.hankun.satokenlearn.mapper.MyRoleMenuMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyRoleMenuService;
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
public class MyRoleMenuServiceImpl extends BaseService<MyRoleMenuMapper, MyRoleMenu> implements MyRoleMenuService {

    /**
     * 获取表格数据
     *
     * @param myRoleMenu
     * @return
     */
    public IPage<MyRoleMenu> getPageListByEntity(MyRoleMenu myRoleMenu) {
        LambdaQueryWrapper<MyRoleMenu> queryWrapper = Wrappers.lambdaQuery();
        return super.page(myRoleMenu, queryWrapper);
    }

}
