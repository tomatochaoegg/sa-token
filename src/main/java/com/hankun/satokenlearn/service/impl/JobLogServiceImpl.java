package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.JobLog;
import com.hankun.satokenlearn.mapper.JobLogMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.JobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class JobLogServiceImpl extends BaseService<JobLogMapper, JobLog> implements JobLogService {

    /**
     * 获取表格数据
     *
     * @param jobLog
     * @return
     */
    public IPage<JobLog> getPageListByEntity(JobLog jobLog) {
        LambdaQueryWrapper<JobLog> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(jobLog.getJobName()), JobLog::getJobName, jobLog.getJobName());
        queryWrapper.like(StrUtil.isNotBlank(jobLog.getJobGroup()), JobLog::getJobGroup, jobLog.getJobGroup());
        queryWrapper.like(StrUtil.isNotBlank(jobLog.getInvokeTarget()), JobLog::getInvokeTarget, jobLog.getInvokeTarget());
        queryWrapper.like(StrUtil.isNotBlank(jobLog.getJobMessage()), JobLog::getJobMessage, jobLog.getJobMessage());
        queryWrapper.like(StrUtil.isNotBlank(jobLog.getJobStatus()), JobLog::getJobStatus, jobLog.getJobStatus());
        queryWrapper.like(StrUtil.isNotBlank(jobLog.getExceptionInfo()), JobLog::getExceptionInfo, jobLog.getExceptionInfo());
        return super.page(jobLog, queryWrapper);
    }

}
