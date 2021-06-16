package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.FileInfo;
import com.hankun.satokenlearn.mapper.FileInfoMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class FileInfoServiceImpl extends BaseService<FileInfoMapper, FileInfo> implements FileInfoService {

    /**
     * 获取表格数据
     *
     * @param fileInfo
     * @return
     */
    public IPage<FileInfo> getPageListByEntity(FileInfo fileInfo) {
        LambdaQueryWrapper<FileInfo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(fileInfo.getName()), FileInfo::getName, fileInfo.getName());
        queryWrapper.like(StrUtil.isNotBlank(fileInfo.getContentType()), FileInfo::getContentType, fileInfo.getContentType());
        queryWrapper.like(StrUtil.isNotBlank(fileInfo.getPath()), FileInfo::getPath, fileInfo.getPath());
        queryWrapper.like(StrUtil.isNotBlank(fileInfo.getUrl()), FileInfo::getUrl, fileInfo.getUrl());
        queryWrapper.like(StrUtil.isNotBlank(fileInfo.getSource()), FileInfo::getSource, fileInfo.getSource());
        return super.page(fileInfo, queryWrapper);
    }

}
