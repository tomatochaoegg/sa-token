package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.DictData;
import com.hankun.satokenlearn.mapper.DictDataMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.DictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class DictDataServiceImpl extends BaseService<DictDataMapper, DictData> implements DictDataService {

    /**
     * 获取表格数据
     *
     * @param dictData
     * @return
     */
    public IPage<DictData> getPageListByEntity(DictData dictData) {
        LambdaQueryWrapper<DictData> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(dictData.getParentId()), DictData::getParentId, dictData.getParentId());
        queryWrapper.like(StrUtil.isNotBlank(dictData.getDictLabel()), DictData::getDictLabel, dictData.getDictLabel());
        queryWrapper.like(StrUtil.isNotBlank(dictData.getDictValue()), DictData::getDictValue, dictData.getDictValue());
        queryWrapper.like(StrUtil.isNotBlank(dictData.getDictType()), DictData::getDictType, dictData.getDictType());
        queryWrapper.like(StrUtil.isNotBlank(dictData.getCssClass()), DictData::getCssClass, dictData.getCssClass());
        queryWrapper.like(StrUtil.isNotBlank(dictData.getListClass()), DictData::getListClass, dictData.getListClass());
        queryWrapper.like(StrUtil.isNotBlank(dictData.getDictStatus()), DictData::getDictStatus, dictData.getDictStatus());
        return super.page(dictData, queryWrapper);
    }

}
