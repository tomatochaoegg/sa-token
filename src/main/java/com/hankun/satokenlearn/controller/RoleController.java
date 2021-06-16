package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.Role;
import com.hankun.satokenlearn.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-04
 */
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", tags = {"角色表操作接口"})
public class RoleController extends BaseController<RoleServiceImpl,Role> {

}
