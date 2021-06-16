package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.MyRoleUser;
import com.hankun.satokenlearn.service.impl.MyRoleUserServiceImpl;
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
@RequestMapping("/my-role-user")
@Api(value = "MyRoleUserController", tags = {"操作接口"})
public class MyRoleUserController extends BaseController<MyRoleUserServiceImpl,MyRoleUser> {

}
