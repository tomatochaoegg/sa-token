package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Post;
import com.hankun.satokenlearn.service.impl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 岗位表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/post")
@Api(value = "PostController", tags = {"岗位表操作接口"})
public class PostController extends BaseController<PostServiceImpl,Post> {

}
