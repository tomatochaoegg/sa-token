package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.MyLog;
import com.hankun.satokenlearn.mapper.MyLogMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.MyLogService;
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
public class MyLogServiceImpl extends BaseService<MyLogMapper, MyLog> implements MyLogService {

    /**
     * 获取表格数据
     *
     * @param myLog
     * @return
     */
    public IPage<MyLog> getPageListByEntity(MyLog myLog) {
        LambdaQueryWrapper<MyLog> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(myLog.getUserName()), MyLog::getUserName, myLog.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getIp()), MyLog::getIp, myLog.getIp());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getDescription()), MyLog::getDescription, myLog.getDescription());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getParams()), MyLog::getParams, myLog.getParams());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getBrowser()), MyLog::getBrowser, myLog.getBrowser());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getType()), MyLog::getType, myLog.getType());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getMethod()), MyLog::getMethod, myLog.getMethod());
        queryWrapper.like(StrUtil.isNotBlank(myLog.getExceptionDetail()), MyLog::getExceptionDetail, myLog.getExceptionDetail());
        return super.page(myLog, queryWrapper);
    }

}
