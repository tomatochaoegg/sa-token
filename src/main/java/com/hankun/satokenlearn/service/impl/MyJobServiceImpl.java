package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyJob;
import com.hankun.satokenlearn.mapper.MyJobMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyJobService;
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
public class MyJobServiceImpl extends BaseService<MyJobMapper, MyJob> implements MyJobService {

    /**
     * 获取表格数据
     *
     * @param myJob
     * @return
     */
    public IPage<MyJob> getPageListByEntity(MyJob myJob) {
        LambdaQueryWrapper<MyJob> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myJob.getJobName()), MyJob::getJobName, myJob.getJobName());
        return super.page(myJob, queryWrapper);
    }

}
