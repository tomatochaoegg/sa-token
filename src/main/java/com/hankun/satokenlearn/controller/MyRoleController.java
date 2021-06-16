package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.MyRole;
import com.hankun.satokenlearn.service.impl.MyRoleServiceImpl;
import org.springframework.web.bind.annotation.*;
import com.hankun.satokenlearn.base.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hankun
 * @since 2021-06-16
 */
@RestController
@RequestMapping("/my-role")
@Api(value = "MyRoleController", tags = {"操作接口"})
public class MyRoleController extends BaseController<MyRoleServiceImpl,MyRole> {

}
