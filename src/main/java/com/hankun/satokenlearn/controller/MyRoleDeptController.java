package com.hankun.satokenlearn.controller;

import io.swagger.annotations.Api;
import com.hankun.satokenlearn.entity.MyRoleDept;
import com.hankun.satokenlearn.service.impl.MyRoleDeptServiceImpl;
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
@RequestMapping("/my-role-dept")
@Api(value = "MyRoleDeptController", tags = {"操作接口"})
public class MyRoleDeptController extends BaseController<MyRoleDeptServiceImpl,MyRoleDept> {

}
