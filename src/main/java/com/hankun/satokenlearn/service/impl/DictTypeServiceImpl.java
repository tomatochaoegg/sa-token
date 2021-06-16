package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.DictType;
import com.hankun.satokenlearn.mapper.DictTypeMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class DictTypeServiceImpl extends BaseService<DictTypeMapper, DictType> implements DictTypeService {

    /**
     * 获取表格数据
     *
     * @param dictType
     * @return
     */
    public IPage<DictType> getPageListByEntity(DictType dictType) {
        LambdaQueryWrapper<DictType> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(dictType.getDictName()), DictType::getDictName, dictType.getDictName());
        queryWrapper.like(StrUtil.isNotBlank(dictType.getDictType()), DictType::getDictType, dictType.getDictType());
        queryWrapper.like(StrUtil.isNotBlank(dictType.getDictStatus()), DictType::getDictStatus, dictType.getDictStatus());
        return super.page(dictType, queryWrapper);
    }

}
