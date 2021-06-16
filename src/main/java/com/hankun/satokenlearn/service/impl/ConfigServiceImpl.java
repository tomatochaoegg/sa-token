package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Config;
import com.hankun.satokenlearn.mapper.ConfigMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class ConfigServiceImpl extends BaseService<ConfigMapper, Config> implements ConfigService {

    /**
     * 获取表格数据
     *
     * @param config
     * @return
     */
    public IPage<Config> getPageListByEntity(Config config) {
        LambdaQueryWrapper<Config> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(config.getConfigName()), Config::getConfigName, config.getConfigName());
        queryWrapper.like(StrUtil.isNotBlank(config.getConfigKey()), Config::getConfigKey, config.getConfigKey());
        queryWrapper.like(StrUtil.isNotBlank(config.getConfigValue()), Config::getConfigValue, config.getConfigValue());
        queryWrapper.like(StrUtil.isNotBlank(config.getConfigType()), Config::getConfigType, config.getConfigType());
        return super.page(config, queryWrapper);
    }

}
