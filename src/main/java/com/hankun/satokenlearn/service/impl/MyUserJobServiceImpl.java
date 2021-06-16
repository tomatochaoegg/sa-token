package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyUserJob;
import com.hankun.satokenlearn.mapper.MyUserJobMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyUserJobService;
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
public class MyUserJobServiceImpl extends BaseService<MyUserJobMapper, MyUserJob> implements MyUserJobService {

    /**
     * 获取表格数据
     *
     * @param myUserJob
     * @return
     */
    public IPage<MyUserJob> getPageListByEntity(MyUserJob myUserJob) {
        LambdaQueryWrapper<MyUserJob> queryWrapper = Wrappers.lambdaQuery();
        return super.page(myUserJob, queryWrapper);
    }

}
