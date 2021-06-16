package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Log;
import com.hankun.satokenlearn.mapper.LogMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class LogServiceImpl extends BaseService<LogMapper, Log> implements LogService {

    /**
     * 获取表格数据
     *
     * @param log
     * @return
     */
    public IPage<Log> getPageListByEntity(Log log) {
        LambdaQueryWrapper<Log> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(log.getOperName()), Log::getOperName, log.getOperName());
        queryWrapper.like(StrUtil.isNotBlank(log.getOperParam()), Log::getOperParam, log.getOperParam());
        queryWrapper.like(StrUtil.isNotBlank(log.getUrl()), Log::getUrl, log.getUrl());
        queryWrapper.like(StrUtil.isNotBlank(log.getIp()), Log::getIp, log.getIp());
        queryWrapper.like(StrUtil.isNotBlank(log.getBusinessName()), Log::getBusinessName, log.getBusinessName());
        queryWrapper.like(StrUtil.isNotBlank(log.getMethod()), Log::getMethod, log.getMethod());
        queryWrapper.like(StrUtil.isNotBlank(log.getResult()), Log::getResult, log.getResult());
        queryWrapper.like(StrUtil.isNotBlank(log.getLogStatus()), Log::getLogStatus, log.getLogStatus());
        queryWrapper.like(StrUtil.isNotBlank(log.getError()), Log::getError, log.getError());
        return super.page(log, queryWrapper);
    }

}
