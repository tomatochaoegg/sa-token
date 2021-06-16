package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyDept;
import com.hankun.satokenlearn.mapper.MyDeptMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyDeptService;
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
public class MyDeptServiceImpl extends BaseService<MyDeptMapper, MyDept> implements MyDeptService {

    /**
     * 获取表格数据
     *
     * @param myDept
     * @return
     */
    public IPage<MyDept> getPageListByEntity(MyDept myDept) {
        LambdaQueryWrapper<MyDept> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myDept.getAncestors()), MyDept::getAncestors, myDept.getAncestors());
        queryWrapper.like(StrUtil.isNotBlank(myDept.getDeptName()), MyDept::getDeptName, myDept.getDeptName());
        return super.page(myDept, queryWrapper);
    }

}
