package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyRoleDept;
import com.hankun.satokenlearn.mapper.MyRoleDeptMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyRoleDeptService;
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
public class MyRoleDeptServiceImpl extends BaseService<MyRoleDeptMapper, MyRoleDept> implements MyRoleDeptService {

    /**
     * 获取表格数据
     *
     * @param myRoleDept
     * @return
     */
    public IPage<MyRoleDept> getPageListByEntity(MyRoleDept myRoleDept) {
        LambdaQueryWrapper<MyRoleDept> queryWrapper = Wrappers.lambdaQuery();
        return super.page(myRoleDept, queryWrapper);
    }

}
