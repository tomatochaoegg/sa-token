package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyDict;
import com.hankun.satokenlearn.mapper.MyDictMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyDictService;
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
public class MyDictServiceImpl extends BaseService<MyDictMapper, MyDict> implements MyDictService {

    /**
     * 获取表格数据
     *
     * @param myDict
     * @return
     */
    public IPage<MyDict> getPageListByEntity(MyDict myDict) {
        LambdaQueryWrapper<MyDict> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myDict.getDictName()), MyDict::getDictName, myDict.getDictName());
        queryWrapper.like(StrUtil.isNotBlank(myDict.getDescription()), MyDict::getDescription, myDict.getDescription());
        return super.page(myDict, queryWrapper);
    }

}
