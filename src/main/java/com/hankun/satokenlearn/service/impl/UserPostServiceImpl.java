package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.UserPost;
import com.hankun.satokenlearn.mapper.UserPostMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class UserPostServiceImpl extends BaseService<UserPostMapper, UserPost> implements UserPostService {

    /**
     * 获取表格数据
     *
     * @param userPost
     * @return
     */
    public IPage<UserPost> getPageListByEntity(UserPost userPost) {
        LambdaQueryWrapper<UserPost> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(userPost.getPostId()), UserPost::getPostId, userPost.getPostId());
        return super.page(userPost, queryWrapper);
    }

}
