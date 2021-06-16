package com.hankun.satokenlearn.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.hankun.satokenlearn.entity.MyMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@DS("db1")
public interface MyMenuService extends IService<MyMenu> {

}
