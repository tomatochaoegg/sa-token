package com.hankun.satokenlearn.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hankun.satokenlearn.entity.Post;
import com.hankun.satokenlearn.mapper.PostMapper;
import com.hankun.satokenlearn.base.service.BaseService;
import com.hankun.satokenlearn.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位表 服务实现类
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@Service
public class PostServiceImpl extends BaseService<PostMapper, Post> implements PostService {

    /**
     * 获取表格数据
     *
     * @param post
     * @return
     */
    public IPage<Post> getPageListByEntity(Post post) {
        LambdaQueryWrapper<Post> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(post.getPostCode()), Post::getPostCode, post.getPostCode());
        queryWrapper.like(StrUtil.isNotBlank(post.getPostName()), Post::getPostName, post.getPostName());
        queryWrapper.like(StrUtil.isNotBlank(post.getPostStatus()), Post::getPostStatus, post.getPostStatus());
        return super.page(post, queryWrapper);
    }

}
