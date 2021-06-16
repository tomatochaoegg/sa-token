package com.hankun.satokenlearn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hankun.satokenlearn.entity.Resources;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
public interface ResourcesService extends IService<Resources> {

    IPage<Resources> getPageListByEntity(Resources resources);

    boolean saveOrUpdate(Resources entity);

    boolean removeById(Serializable id);

    List<Resources> getRouterList();

}
