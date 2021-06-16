package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyDictDetail;
import com.hankun.satokenlearn.mapper.MyDictDetailMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyDictDetailService;
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
public class MyDictDetailServiceImpl extends BaseService<MyDictDetailMapper, MyDictDetail> implements MyDictDetailService {

    /**
     * 获取表格数据
     *
     * @param myDictDetail
     * @return
     */
    public IPage<MyDictDetail> getPageListByEntity(MyDictDetail myDictDetail) {
        LambdaQueryWrapper<MyDictDetail> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myDictDetail.getLabel()), MyDictDetail::getLabel, myDictDetail.getLabel());
        queryWrapper.like(StrUtil.isNotBlank(myDictDetail.getValue()), MyDictDetail::getValue, myDictDetail.getValue());
        return super.page(myDictDetail, queryWrapper);
    }

}
