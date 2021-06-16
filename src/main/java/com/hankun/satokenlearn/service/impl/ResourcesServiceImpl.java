package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.constant.Constant;
import com.hankun.satokenlearn.entity.Resources;
import com.hankun.satokenlearn.mapper.ResourcesMapper;
import com.hankun.satokenlearn.service.ResourcesService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class ResourcesServiceImpl extends BaseService<ResourcesMapper, Resources> implements ResourcesService {

    /**
     * 获取表格数据
     *
     * @param resources
     * @return
     */
    public IPage<Resources> getPageListByEntity(Resources resources) {
        LambdaQueryWrapper<Resources> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(resources.getParentId()), Resources::getParentId, resources.getParentId());
        queryWrapper.like(StrUtil.isNotBlank(resources.getParentIds()), Resources::getParentIds, resources.getParentIds());
        queryWrapper.like(StrUtil.isNotBlank(resources.getResName()), Resources::getResName, resources.getResName());
        queryWrapper.like(StrUtil.isNotBlank(resources.getResCode()), Resources::getResCode, resources.getResCode());
        queryWrapper.like(StrUtil.isNotBlank(resources.getResPath()), Resources::getResPath, resources.getResPath());
        queryWrapper.like(StrUtil.isNotBlank(resources.getHttpMethod()), Resources::getHttpMethod, resources.getHttpMethod());
        queryWrapper.like(StrUtil.isNotBlank(resources.getResStatus()), Resources::getResStatus, resources.getResStatus());
        queryWrapper.like(StrUtil.isNotBlank(resources.getResType()), Resources::getResType, resources.getResType());
        return super.page(resources, queryWrapper);
    }

    /**
     * 保存和修改
     *
     * @param entity
     * @return
     */
    @CacheEvict(value = {"resource:router"}, allEntries = true, condition = "#result == true")
    @Override
    public boolean saveOrUpdate(Resources entity) {
        return super.saveOrUpdate(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @CacheEvict(value = {"resource:router"}, allEntries = true, condition = "#result == true")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    /**
     * 获取路由表
     *
     * @return
     */
    @Cacheable(value = "resource:router")
    public List<Resources> getRouterList() {
        return list(Wrappers.<Resources>lambdaQuery()
                .select(Resources::getResCode, Resources::getResPath, Resources::getHttpMethod)
                .isNotNull(Resources::getResCode)
                .isNotNull(Resources::getResPath)
                .isNotNull(Resources::getHttpMethod)
                .eq(Resources::getResStatus, Constant.ZERO)
                .eq(Resources::getResType, Constant.ONE).orderByAsc(Resources::getResSort));
    }

}
