package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Job;
import com.hankun.satokenlearn.mapper.JobMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class JobServiceImpl extends BaseService<JobMapper, Job> implements JobService {

    /**
     * 获取表格数据
     *
     * @param job
     * @return
     */
    public IPage<Job> getPageListByEntity(Job job) {
        LambdaQueryWrapper<Job> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(job.getJobName()), Job::getJobName, job.getJobName());
        queryWrapper.like(StrUtil.isNotBlank(job.getJobGroup()), Job::getJobGroup, job.getJobGroup());
        queryWrapper.like(StrUtil.isNotBlank(job.getInvokeTarget()), Job::getInvokeTarget, job.getInvokeTarget());
        queryWrapper.like(StrUtil.isNotBlank(job.getCronExpression()), Job::getCronExpression, job.getCronExpression());
        queryWrapper.like(StrUtil.isNotBlank(job.getMisfirePolicy()), Job::getMisfirePolicy, job.getMisfirePolicy());
        queryWrapper.like(StrUtil.isNotBlank(job.getConcurrent()), Job::getConcurrent, job.getConcurrent());
        queryWrapper.like(StrUtil.isNotBlank(job.getJobStatus()), Job::getJobStatus, job.getJobStatus());
        return super.page(job, queryWrapper);
    }

}
