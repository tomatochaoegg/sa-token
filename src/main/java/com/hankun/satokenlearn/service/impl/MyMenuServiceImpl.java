package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyMenu;
import com.hankun.satokenlearn.mapper.MyMenuMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyMenuService;
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
public class MyMenuServiceImpl extends BaseService<MyMenuMapper, MyMenu> implements MyMenuService {

    /**
     * 获取表格数据
     *
     * @param myMenu
     * @return
     */
    public IPage<MyMenu> getPageListByEntity(MyMenu myMenu) {
        LambdaQueryWrapper<MyMenu> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myMenu.getMenuName()), MyMenu::getMenuName, myMenu.getMenuName());
        queryWrapper.like(StrUtil.isNotBlank(myMenu.getIcon()), MyMenu::getIcon, myMenu.getIcon());
        queryWrapper.like(StrUtil.isNotBlank(myMenu.getUrl()), MyMenu::getUrl, myMenu.getUrl());
        queryWrapper.like(StrUtil.isNotBlank(myMenu.getPermission()), MyMenu::getPermission, myMenu.getPermission());
        return super.page(myMenu, queryWrapper);
    }

}
