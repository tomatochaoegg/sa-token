package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.UserPost;
import com.hankun.satokenlearn.service.impl.UserPostServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 用户与岗位关联表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/user-post")
@Api(value = "UserPostController", tags = {"用户与岗位关联表操作接口"})
public class UserPostController extends BaseController<UserPostServiceImpl,UserPost> {

}
