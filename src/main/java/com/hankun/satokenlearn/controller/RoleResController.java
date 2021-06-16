package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.RoleRes;
import com.hankun.satokenlearn.service.impl.RoleResServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 角色和资源关联表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/role-res")
@Api(value = "RoleResController", tags = {"角色和资源关联表操作接口"})
public class RoleResController extends BaseController<RoleResServiceImpl,RoleRes> {

}
